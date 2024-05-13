import MyCanva from "./3D/MyCanva";
import "./mainPage.css";

export default function MainPage() {
  return (
    <div className="mainpage-conatainer-big">
      <div className="mainpage-conatainer-back">
        <div className="mainpage-conatainer-front">
          <MyCanva />
        </div>
      </div>
      <div className="mainpage-conatainer-back">
        <div className="mainpage-conatainer-front">
          Valami
        </div>
      </div>
      <div className="mainpage-conatainer-back">
        <div className="mainpage-conatainer-front">
          Weather
        </div>
      </div>
      <div className="mainpage-conatainer-back">
        <div className="mainpage-conatainer-front">
          Clock
        </div>
      </div>
    </div>
  );
}
