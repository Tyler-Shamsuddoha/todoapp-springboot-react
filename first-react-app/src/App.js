//import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from "react";
import TodoItem from './Components/todoItem';

function App() {

  const [todoItems, setTodoItems] = useState(null)

  useEffect(() => {
    // This is the onLoad() section
    // do something when app loads up
    console.log("Loaded up");

    // If there are no todoItems, fetch items
    if (!todoItems) {
      fetch("http://localhost:8080/api/todoItems")
        .then((response) => response.json())
        .then((data) => {
          console.log("To do items list: ", data);
          // Update the 
          setTodoItems(data);
        });
    }
  });

  function addNewItem() {
    fetch('http://localhost:8080/')

  }
  

  return (
  <>
  <div>
    <button onClick={addNewItem}> Add new To Do Item </button>
  </div>

    <div>
      {todoItems
        ? todoItems.map(todoItem => {
          return <TodoItem key={todoItem.id} data={todoItem} />;
        }) : 'Need to fetch items...'}
    </div>
  </>
  );

}

export default App;