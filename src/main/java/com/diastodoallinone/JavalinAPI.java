package com.diastodoallinone;

import com.diastodoallinone.model.ToDoItem;
import com.google.gson.Gson;
import io.javalin.Javalin;

import java.util.List;

public class JavalinAPI {
    Gson gson = new Gson();

    Javalin app = Javalin.create().start(7000);

    public void homeEndPoint() {
        app.get("/", ctx -> ctx.result("Hello World"));

    }

    public void createEndPoint() {
        app.post("/create", ctx -> {
            String todoShortDescription = ctx.formParam("todoShortDescription");
            String todoLongDescription = ctx.formParam("todoLongDescription");
            String todoDueDate = ctx.formParam("todoDueDate");
            String todoOrder = ctx.formParam("todoOrder");
            String hasBeenDone = ctx.formParam("hasBeenDone");

            System.out.println(todoShortDescription);
            ToDoDAO todoItem = new ToDoDAO();
            todoItem.createDbColumns();
            todoItem.createToDoListItem(todoShortDescription, todoLongDescription, todoDueDate, todoOrder, hasBeenDone);
            ctx.status(200);
        });


    }

    public void getEndPoint() {
        app.get("/dbitems", ctx -> {
            ToDoDAO dbInteraction = new ToDoDAO();
            List<ToDoItem> toDoItemList = dbInteraction.getToDOItems();
            ctx.result(gson.toJson(toDoItemList));
            ctx.status(200);
        });

    }


}
