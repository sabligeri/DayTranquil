
export default function NoteList({del, notes}) {
  

  return (
    <div id="note-list">
      {/* <h2>Your Notes</h2> */}
      <div id="note-grid">
        {notes.map((note: note, index) => (
          <div id="note" key={index}>
            <h3>{note.title}</h3>
            <h3 className="note-text">{note.text}</h3>
            <button onClick={() => del(note.id)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
}
