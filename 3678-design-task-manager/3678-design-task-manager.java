class TaskManager {

    private PriorityQueue<Task> taskPq;
    private Map<Integer,Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        taskPq = new PriorityQueue<>((a,b)->{
                if(a.getPriority() != b.getPriority()){
                    return b.getPriority()-a.getPriority();
                }
                return b.getTaskId()-a.getTaskId();
        });    
        taskMap = new HashMap<>();

        for(List<Integer> currTask: tasks){
            Task t = new Task(currTask.get(1),currTask.get(2),currTask.get(0));
            taskMap.put(currTask.get(1),t);
            taskPq.add(t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(taskId,priority,userId);
        taskMap.put(taskId,t);
        taskPq.add(t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        Task t = new Task(taskId,newPriority,oldTask.getUserId());
        taskMap.put(taskId,t);
        taskPq.add(t);
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while(!taskPq.isEmpty()){
            Task currTask = taskPq.poll();
            int currTaskId = currTask.getTaskId();
            if(taskMap.containsKey(currTaskId) && taskMap.get(currTaskId).getPriority() == currTask.getPriority() && taskMap.get(currTaskId).getUserId() == currTask.getUserId()){
                rmv(currTaskId);
                return currTask.getUserId();
            }
        }
        return -1;
    }
}

class Task{
    private final int taskId;
    private int priority;
    private final int userId;

    public Task(int taskIdIn, int priorityIn, int userIdIn){
        taskId = taskIdIn;
        priority = priorityIn;
        userId = userIdIn;
    }

    public int getTaskId(){
        return taskId;
    }

    // public void setPriority(int priorityIn){
    //     priority = priorityIn;
    // }

    public int getPriority(){
        return priority;
    }

    public int getUserId(){
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */