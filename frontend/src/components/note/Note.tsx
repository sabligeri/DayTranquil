import { useState } from "react";
import { FaHeart } from "react-icons/fa";

interface NoteProps {
    title: string;
    index: number;
    del: (noteId: number) => void;
    text: string; // Define the type of 'text' prop
    noteId: number;
  }
  
  export default function Note({ title, index, del, text, noteId }: NoteProps) {


    
    const [fav, setFav] = useState(false);
    return (
        <div className="note" key={index}>
            <div className="note-title-container">
                <h3>{title}</h3>
                    <FaHeart
                    id="heart-img"
                        key={index}
                        className={(fav) ? "haert-active" : "heart-inactive"}
                        onClick={() => (fav) ? setFav(false) : setFav(true)}
                        size={20}
                    />
            </div>
            <h3 className="note-text">{text}</h3>
            <button onClick={() => del(noteId)}>Delete</button>
        </div>
    )
}