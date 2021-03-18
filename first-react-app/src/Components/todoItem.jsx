import React, { Fragment, useEffect, useState } from 'react'

const TodoItem = (props) => {
    // Never update the getter in REACT, instead use the setter method
    const [todoItem, setTodoItem] = useState(props.data)


    // function updateIsCompleted() {
         // Dereference
        //  setTodoItem({'id': id, 'isCompleted': isCompleted, 'task': task})
    //     setTodoItem({...todoItem, isCompleted: !todoItem.isCompleted})
    // }


    // Hook to keep track of updates to the TodoItem
    // When state changes for TodoItem, update data in server to represent change
    useEffect(() => {
        console.log("The Todo Item has changed", todoItem);
    },[todoItem]);


    return (
        <>
            <input
            type="checkbox" checked={todoItem.isCompleted} onChange={() => setTodoItem({...todoItem, isCompleted: !todoItem.isCompleted})} />{"  "}
            <span>
                {todoItem.task}
            </span>
        </>
    )
};

export default TodoItem;