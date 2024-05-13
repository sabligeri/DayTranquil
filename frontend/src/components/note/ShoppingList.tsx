import { useEffect, useState } from "react";
import Divider from "@mui/material/Divider";
import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCircleChevronRight } from "@fortawesome/free-solid-svg-icons";
import { faCircleChevronLeft } from "@fortawesome/free-solid-svg-icons";

export default function ShoppingList() {
  const [items, setItems] = useState([]);
  const [bought, setBought] = useState(false);
  const [productName, setInputName] = useState("");

  interface item {
    id: number;
    productName: string;
    quantity: number;
    bought: boolean;
  }

  useEffect(() => {
    fetchItems();
  }, []);

  async function fetchItems() {
    const response = await fetch("/api/shopping");
    const items = await response.json();
    setItems(items);
  }

  async function addItem(e) {
    e.preventDefault();
    const newItem = {
      name: productName,
    };
    try {
      const response = await fetch(`/api/shopping`, {
        method: "POST",
        body: JSON.stringify(newItem),
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        fetchItems();
      }

      const responseData = await response.json();
      console.log(responseData);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  }

  async function updateBought(id: number) {
    console.log(bought);
    setBought(!bought);
    console.log(bought);
    const response = await fetch(
      `/api/shopping/bought/${id}?isbought=${bought}`,
      {
        method: "PUT",
      }
    );
    if (response.ok) {
      console.log("ok");
      fetchItems();
    }
  }

  return (
    <>
      <div id="add-new-item">
        <form onSubmit={(e) => addItem(e)}>
          <input
            type="text"
            placeholder="Add new item..."
            onChange={(e) => setInputName(e.target.value)}
          />
          <button>+</button>
        </form>
      </div>

      <div id="shopping-list-container">
        <table id="shopping-list-table">
          <thead>
            <tr>
              <th>Bought</th>
              <th>Product Name</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {items
              .sort((a: item, b: item) => a.id - b.id)
              .map((item: item) => (
                <React.Fragment key={item.id}>
                  <tr>
                    <td>
                      <input
                        type="checkbox"
                        checked={item.bought}
                        onClick={() => updateBought(item.id)}
                      />
                    </td>
                    <td>{item.productName}</td>
                    <td>
                      <div className="item-quantity">
                        <FontAwesomeIcon className="decr-btn" icon={faCircleChevronLeft} />
                        <span>{item.quantity}</span>
                        <FontAwesomeIcon className="incr-btn" icon={faCircleChevronRight} />
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td colSpan={3}>
                      <Divider
                        variant="middle"
                        style={{ background: "white" }}
                        className="divider"
                      />
                    </td>
                  </tr>
                </React.Fragment>
              ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
