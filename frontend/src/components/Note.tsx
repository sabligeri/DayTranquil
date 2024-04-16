import React, { useEffect, useState } from "react";


export default function Note () {
    const [notes, setNotes] = useState([]);
    const [userId, setUserId] = useState();

    useEffect(() => {
        const id = JSON.parse(localStorage.getItem('userId')!);
        if (id > 0) {
          setUserId(id);
        }
      }, []);


  
    useEffect(() => {
      fetch(`/api/note/${userId}/all`)
        .then(response => response.json())
        .then(data => setNotes(data))
        .catch(error => console.error("Failed to load notes:", error));
    }, [userId]);

  
    const handleDeleteNote = async (noteId: number) => {
      const response = await fetch(`/api/note/${userId}/delete/${noteId}`, {
        method: 'DELETE',
      });
  
      if (response.ok) {
        setNotes(notes.filter(note => note.id !== noteId));
      }
    };
  
    return (
      <div>
        <h2>Your Notes</h2>
        <ul>
          {notes.map(note => (
            <th key={note.id}>
                <h3>{note.title}</h3>
                <h3>{note.text}</h3>
              <button onClick={() => handleDeleteNote(note.id)}>Delete</button>
            </th>
          ))}
        </ul>
      </div>
    );
  };
  