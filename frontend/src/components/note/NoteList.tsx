import { useEffect, useState } from "react";

export default function NoteList() {
  const [notes, setNotes] = useState([]);
  const [userId, setUserId] = useState(4);

  interface note {
    created: Date;
    id: number;
    text: string;
    title: string;
    userId: number;
  }

  useEffect(() => {
    const id = JSON.parse(localStorage.getItem("userId")!);
    if (id > 0) {
      setUserId(id);
      const fetchNotes = async (id:number) => {
        try {
          const response = await fetch(`/api/note/${id}/all`);
          const data = await response.json();
          setNotes(data);
          console.log(data);
        } catch (error) {
          console.error("Failed to load notes:", error);
        }
      };
  
      fetchNotes(id);
    }
  }, []);


  async function handleDeleteNote(noteId: number) {
    const response = await fetch(`/api/note/${userId}/delete/${noteId}`, {
      method: "DELETE",
    });

    if (response.ok) {
      setNotes(notes.filter((note: note) => note.id !== noteId));
    } else {
      console.error("Failed to delete the note.");
    }
  }

  return (
    <div id="note-list">
      <h2>Your Notes</h2>
      <div id="note-grid">
        {notes.map((note: note) => (
          <div id="note" key={note.id}>
            <h3>{note.title}</h3>
            <h3>{note.text}</h3>
            <button onClick={() => handleDeleteNote(note.id)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
}
