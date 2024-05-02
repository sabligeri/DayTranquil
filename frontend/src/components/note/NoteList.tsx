import Note from "./Note";


interface Note {
  created: Date;
  id: number;
  text: string;
  title: string;
  userId: number;
}

interface NoteListProps {
  del: (noteId: number) => void;
  notes: Note[];
}

export default function NoteList({ del, notes }: NoteListProps) {
  return (
    <div id="note-list">
      {/* <h2>Your Notes</h2> */}
      <div id="note-grid">
        {notes && notes.map((note, index: number) => (
          <Note
            title={note.title}
            text={note.text}
            index={index}
            del={del}
            noteId={note.id}
          />
        ))}
      </div>
    </div>
  );
}
