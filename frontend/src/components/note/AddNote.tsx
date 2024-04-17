import { useState } from "react";

export default function AddNote({reFetchNotes}) {
  const [title, setTitle] = useState("")
  const [text, setText] = useState("")

  interface NewNote {
    title: string;
    text: string;
    userId: string;
  }

  async function addNote(newNote: NewNote) {
    try {
      const response = await fetch('/api/note/1/add', {
        method: 'POST',
        body: JSON.stringify(newNote),
        headers: {
          'Content-Type': 'application/json',
        },
      });
      
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      
      const responseData = await response.json();
      console.log(responseData);
      reFetchNotes()
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }
  

  function handleAddNote() {
    const userId = JSON.parse(localStorage.getItem("userId")!)
    console.log(userId);
    const newNote = {
      title: title,
      text: text,
      userId: userId
    }
    addNote(newNote)
  }

  return (
    <div id="add-note">
      <div id="add-note-headbar">
        <h2>Add new note</h2>
        <button onClick={() => handleAddNote()}>Save</button>
      </div>
      <div id="add-note-textarea-container" >

      <textarea id="add-note-textarea-title" onChange={(e) => setTitle(e.target.value)}>Your title...</textarea>
      <textarea id="add-note-textarea-text" onChange={(e) => setText(e.target.value)}>Your text...</textarea>
      </div>
    </div>
  );
}
