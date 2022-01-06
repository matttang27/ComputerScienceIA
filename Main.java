class Main {
    public static void main(String args[]) {
        System.out.println("HI");
        Manager manager = new Manager();
        Task r = manager.tasker.blankTask();
        System.out.println(r);
    }
}