package com.diastodoallinone.model;

/**
 * Created by dia on 26/05/2019.
 */
public class ToDoItem {
    private String toDoShortDescription;
    private String todoLongDescription;
    private String todoDueDate;
    private String todoOrder;
    private String  hasBeenDone;

    public ToDoItem(String toDoShortDescription, String todoLongDescription, String todoDueDate, String todoOrder, String hasBeenDone) {
        this.toDoShortDescription = toDoShortDescription;
        this.todoLongDescription = todoLongDescription;
        this.todoDueDate = todoDueDate;
        this.todoOrder = todoOrder;
        this.hasBeenDone = hasBeenDone;
    }

    public String getToDoShortDescription() {
        return toDoShortDescription;
    }

    public void setToDoShortDescription(String toDoShortDescription) {
        this.toDoShortDescription = toDoShortDescription;
    }

    public String getTodoLongDescription() {
        return todoLongDescription;
    }

    public void setTodoLongDescription(String todoLongDescription) {
        this.todoLongDescription = todoLongDescription;
    }

    public String getTodoDueDate() {
        return todoDueDate;
    }

    public void setTodoDueDate(String todoDueDate) {
        this.todoDueDate = todoDueDate;
    }

    public String getTodoOrder() {
        return todoOrder;
    }

    public void setTodoOrder(String todoOrder) {
        this.todoOrder = todoOrder;
    }

    public String getHasBeenDone() {
        return hasBeenDone;
    }

    public void setHasBeenDone(String hasBeenDone) {
        this.hasBeenDone = hasBeenDone;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "toDoShortDescription='" + toDoShortDescription + '\'' +
                ", todoLongDescription='" + todoLongDescription + '\'' +
                ", todoDueDate='" + todoDueDate + '\'' +
                ", todoOrder='" + todoOrder + '\'' +
                ", hasBeenDone='" + hasBeenDone + '\'' +
                '}';
    }
}
