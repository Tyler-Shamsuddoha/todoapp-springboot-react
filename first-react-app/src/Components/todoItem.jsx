import React, { Fragment, useEffect, useState } from 'react'

const TodoItem = (props) => {
    // Never update the getter in REACT, instead use the setter method
    const [todoItem, setTodoItem] = useState(props.data);
    const [isDirty, setDirty] = useState(false)

    // function updateIsCompleted() {
    // Dereference
    //  setTodoItem({'id': id, 'isCompleted': isCompleted, 'task': task})
    //     setTodoItem({...todoItem, isCompleted: !todoItem.isCompleted})
    // }


    // Hook to keep track of updates to the TodoItem
    // When state changes for TodoItem, update data in server to represent change
    useEffect(() => {
        if (isDirty) {
            fetch(`http://localhost:8080/api/todoItems${todoItem.id}`, {
                method: 'PUT',
                headers: {
                    "content-type": "application/json",
                },
                body: JSON.stringify(todoItem), // This is the data we are sending back to the server side (A to do item)
            })
                .then((response) => response.json())
                .then((data) => {
                    setDirty(false);
                    setTodoItem(data);
                });
        }
    }, [todoItem, isDirty]);


    return (
        <>
            <input
                type="checkbox" checked={todoItem.isCompleted} onChange={() => {
                setDirty(true);
                setTodoItem({ ...todoItem, isCompleted: !todoItem.isCompleted })
                }} />{"  "}
            <span>
                {todoItem.task}
            </span>
        </>
    )
};

export default TodoItem;