//import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from "react";
import TodoItem from './Components/todoItem';

function App() {

  const [todoItems, setTodoItems] = useState(null)

  useEffect(() => {
    // This is the onLoad/do something when app loads up
    console.log("Loaded up");

    // If there are no todoItems, fetch items
    if (!todoItems) {
      fetch("http://localhost:8080/api/todoItems")
        .then((response) => response.json())
        .then((data) => {
          console.log("To do items list: ", data);
          // Update items to show them
          setTodoItems(data);
        });
    }
  }, [todoItems]);

  function addNewItem(){
    fetch("http://localhost:8080/api/todoItems", {
      headers: {
        'content-type': 'application/json'
      },
      method: 'POST' 
    }).then((response)  => response.json()) // promise to take the response and translate it into javascript object, returns another promise
      .then((newTodoItem) => {
        console.log(newTodoItem);
        // Update the state, to show the recieved TodoItem
        setTodoItems([...todoItems, newTodoItem]);
      });
  }


  return (
    <>
    <div>
      <button onClick={addNewItem}> Add New Item </button>
    </div>

      <div>
        {todoItems
          ? todoItems.map((todoItem) => {
            return <TodoItem key={todoItem.id} data={todoItem} />;
          })
          : 'Need to fetch items...'}
      </div>
    </>
  );
}

export default App;