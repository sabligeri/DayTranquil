import NoteHeadBar from "./NoteHeadBar";
import NoteList from "./NoteList";
import "./Note.css";
import { useEffect, useState } from "react";

interface note {
  noteId: number;
  title: string;
  text: string;
  isFavorite: boolean;
}

export default function NotePage() {
  const [notes, setNotes] = useState([]);
  const [userId, setUserId] = useState(0);

  /*  const emptyNote: note = {
    created: new Date(),
    id: 0,
    text: "",
    title: "",
    userId: 0,
  }; */

  function createEmptyNote(noteId: number): note {
    const emptyNote = {
      noteId: noteId,
      text: "",
      title: "",
      isFavorite: false,
    };
    return emptyNote;
  }

  useEffect(() => {
    const userId = JSON.parse(localStorage.getItem("userId")!);
    if (userId > 0) {
      setUserId(userId);
    }
  }, []);

  useEffect(() => {
    fetchNotes();
  }, [userId]);

  async function fetchNotes(): Promise<void> {
    try {
      const response = await fetch(`/api/note/${userId}`);
      const data = await response.json();
      if (data.length >= 3) {
        data.splice(3, 0, createEmptyNote(-1));
        data.splice(3, 0, createEmptyNote(-2));
      }

      setNotes(data);
      //console.log(notes);
    } catch (error) {
      console.error("Failed to load notes:", error);
    }
  }

  async function handleDeleteNote(noteId: number) {
    const response = await fetch(`/api/note/${userId}/${noteId}`, {
      method: "DELETE",
    });

    if (response.ok) {
      fetchNotes();
    } else {
      console.error("Failed to delete the note.");
    }
  }

  return (
    <div id="note-page">
      <NoteHeadBar reFetchNotes={fetchNotes} userId={userId} />
      <NoteList del={handleDeleteNote} notes={notes} />
    </div>
  );
}
