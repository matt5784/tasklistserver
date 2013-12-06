package edu.vu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Api(
        name = "tasklistserver",
        version = "v1",
        scopes = "https://www.googleapis.com/auth/userinfo.email",
        clientIds = {com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID}
    )

public class RequestHandler {

    private static final String NAME = "tasklist";
    private final Key taskListKey;
    private final DatastoreService datastore;
    private final Map<Integer, Task> mAllTasks = new HashMap<Integer, Task>();
    private final Map<User, List<Task>> mAssignedTasks = new HashMap<User, List<Task>>();


    public RequestHandler() {
        taskListKey = KeyFactory.createKey("Tasklist", NAME);
        datastore = DatastoreServiceFactory.getDatastoreService();
    }

    @ApiMethod(name = "addtask")
    public Task addTask(@Named("name") final String name, @Named("time") final String time, @Named("lat") final int lat, @Named("lon") final int lon) {

        final UserService userService = UserServiceFactory.getUserService();
        final User user = userService.getCurrentUser();

        final Task temp = new Task(name, time, lat, lon);


        final String content = temp.toString();
        final Date date = new Date();
        final Entity task = new Entity("Task", taskListKey);
        task.setProperty("user", user);
        task.setProperty("date", date);
        task.setProperty("content", content);


        datastore.put(task);
        mAllTasks.put(new Random().nextInt(), temp);

        return temp;
    }

    @ApiMethod(name = "gettasks")
    public Map<Integer, Task> getTasks() {

        final Map<Integer, Task> temp = new HashMap<Integer, Task>();

        final Query query = new Query("Task", taskListKey).addSort("date", Query.SortDirection.DESCENDING);

        //Note that this 100 is a hard limit on the number of tasks able to be stored
        final List<Entity> tasks = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(100));

        if (tasks.isEmpty()) {

        } else {
            int i = 0;
            for (final Entity task : tasks) {
                temp.put(i, new Task((String) task.getProperty("content")));
                i++;
            }
        }

        return temp;
    }

    @ApiMethod(name = "assigntask")
    public boolean assignTask(@Named("user") final User user, @Named("id") final int id) {
        if (user != null && mAllTasks.containsKey(id)) {
            if (mAssignedTasks.get(user) == null) {
                final List<Task> temp = new ArrayList<Task>();
                mAssignedTasks.put(user, temp);
            }
            mAssignedTasks.get(user).add(mAllTasks.get(id));
            return true;
        } else {
            return false;
        }
    }

}
