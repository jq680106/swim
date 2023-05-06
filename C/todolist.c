#include <stdio.h>
#include <string.h>

#define MAX_TASKS 10
#define MAX_LENGTH 50

int main() {
    char tasks[MAX_TASKS][MAX_LENGTH];
    int count = 0;
    int choice;

    while (1) {
        printf("Welcome to your To-Do List!\n");
        printf("1. Add task\n");
        printf("2. View tasks\n");
        printf("3. Clear list\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {
            if (count == MAX_TASKS) {
                printf("Sorry, your to-do list is full.\n");
            } else {
                printf("Enter task: ");
                scanf("%s", tasks[count]);
                count++;
                printf("Task added!\n");
            }
        } else if (choice == 2) {
            if (count == 0) {
                printf("Your to-do list is empty.\n");
            } else {
                printf("Your tasks:\n");
                for (int i = 0; i < count; i++) {
                    printf("%d. %s\n", i+1, tasks[i]);
                }
            }
        } else if (choice == 3) {
            memset(tasks, 0, sizeof(tasks));
            count = 0;
            printf("To-do list cleared!\n");
        } else if (choice == 4) {
            printf("Goodbye!\n");
            break;
        } else {
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
