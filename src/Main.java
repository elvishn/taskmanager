//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Task task1 = new Task("Code", "Write constructor");
    System.out.println(task1.getTitle());
    System.out.println(task1.getId());
    System.out.println(task1.getStatus());
    System.out.println(task1.getDescription());
    System.out.println(task1.getCreatedAt());
}
