import NoteHeadBar from "./NoteHeadBar";
import NoteList from "./NoteList";
import "./Note.css";
import { useEffect, useState } from "react";

export default function NotePage() {
  const [notes, setNotes] = useState([]);
  const [userId, setUserId] = useState(0);

  interface note {
    created: Date;
    id: number;
    text: string;
    title: string;
    userId: number;
  }

  const emptyNote: note = {
    created: new Date(),
    id: 0,
    text: "",
    title: "",
    userId: 0,
  };

  useEffect(() => {
    const userId = JSON.parse(localStorage.getItem("userId")!);
    if (userId > 0) {
      setUserId(userId);
      fetchNotes();
    }
  }, []);

  async function fetchNotes(): Promise<void> {
    try {
      const response = await fetch(`/api/note/${userId}/all`);
      const data = await response.json();
      if (data.length >= 3) {
        data.splice(3, 0, emptyNote);
        data.splice(3, 0, emptyNote);
      }
      setNotes(data);
    } catch (error) {
      console.error("Failed to load notes:", error);
    }
  }

  async function handleDeleteNote(noteId: number) {
    const response = await fetch(`/api/note/${userId}/delete/${noteId}`, {
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
      <NoteHeadBar reFetchNotes={fetchNotes} />
      <NoteList del={handleDeleteNote} notes={notes} />
    </div>
  );
}
