//import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from "react";
import TodoItem from './Components/todoItem';

function App() {

  const [todoItems, setTodoItems] = useState(null)

  useEffect(() => {
    // do something when app loads up
    console.log("Loaded up");

    if (!todoItems) {
      fetch("http://localhost:8080/api/todoItems")
        .then((response) => response.json())
        .then((data) => {
          console.log("To do items list: ", data);
          setTodoItems(data);
        });
    }
  });




  return (
    <div>
      {todoItems
        ? todoItems.map(todoItem => {
          return <TodoItem key={todoItem.id} data={todoItem} />;
        }) : 'loading data'}
    </div>
  );
}

export default App;