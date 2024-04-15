import { useEffect, useState } from "react";

function MyTest() {
  const [myString, setMyString] = useState(null);

  async function fetchData(url:string) {
    try {
      const response = await fetch(url);
      const data = await response.json();
      setMyString(data)
      return data;
    } catch (error) {
      // Handle errors here
      console.error("Error fetching data:", error);
    }
  }

  useEffect(() => {
    fetchData("/api/test");
    console.log(myString);
  }, []);

  return (
    <>
      <h1>{myString && myString.name}</h1>
    </>
  );
}

export default MyTest;
