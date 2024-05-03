import { useEffect, useState } from "react";

export default function AddNote({reFetchNotes, userId}) {
  const [title, setTitle] = useState("")
  const [text, setText] = useState("")
  const [currentDate, setCurrentDate] = useState(new Date());

  interface NewNote {
    title: string;
    text: string;
    userId: string;
  }

useEffect(() => {
  //console.log(currentDate);
  
  //setCurrentDate(new Date());
})

  async function addNote(newNote: NewNote) {
    try {
      const response = await fetch(`/api/note/${userId}`, {
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
      //console.log(responseData);
      reFetchNotes()
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }
  

  function handleAddNote() {
    const userId = JSON.parse(localStorage.getItem("userId")!)
    //console.log(userId);
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
      <input id="add-note-set-date" type="date"  /* value={new Date().toISOString().split('T')[0]} *//>
      <textarea id="add-note-textarea-title" onChange={(e) => setTitle(e.target.value)} placeholder="Your title..."></textarea>
      <textarea id="add-note-textarea-text" onChange={(e) => setText(e.target.value)} placeholder="Your text..."></textarea>
      </div>
    </div>
  );
}
