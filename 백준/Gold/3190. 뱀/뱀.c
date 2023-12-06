#include <stdio.h>
#include <stdlib.h>


#define _CRT_SECURE_NO_WARNINGS
typedef int element;


#define UP 80
#define DOWN 81
#define RIGHT 82
#define LEFT 83

typedef struct List {

	element X;
	element Y;
	struct List* Node;

}List;


typedef struct ap_XY {

	int X;
	int Y;

}ap_XY;

typedef struct ctrl {

	int time;
	char dir;

}ctrl;

List* newnode(element X,element Y) {

	List* tmp = (List*)malloc(sizeof(List));
	tmp->X = X;
	tmp->Y = Y;
	tmp->Node = NULL;
	return tmp;

}

void input(List** head,List** rear, element X,element Y) {


	if (*head == NULL) {
		*head =  newnode(X, Y);
		*rear = *head;
		return;
	}

	(*rear)->Node = newnode(X, Y);
	*rear = (*rear)->Node;

}

void pop(List** head,List** rear) {

	List* tmp = *head;

	if (*head == *rear) {
		*head = tmp->Node;
		*rear = tmp->Node;
		free(tmp);
		return;
	}

	*head = tmp->Node;
	free(tmp);


}

int same_XY(List** head, List** rear) {

	if (*rear == *head) {
		return 0;
	}
	for (List* tmp = *head; tmp->Node != *rear; tmp = tmp->Node) {
		if ((*rear)->X == tmp->X && (*rear)->Y == tmp->Y) {
			return 1;
		}
	}
	return 0;
}


int main(void) {


	int board, EA, N , X = 1 , Y = 1, time = -1;
	ap_XY * apple;
	ctrl* User_ctrl;
	List* head = NULL, *rear = NULL;
	int dir = RIGHT;
	int i = 0,j = 0;

	scanf("%d", &board);
	scanf("%d", &EA);

	apple = (ap_XY*)malloc(sizeof(struct ap_XY) * EA);
	while (i <EA) {
		scanf("%d %d", &((apple + i)->X), &((apple + i)->Y));

		i++;
	}
	scanf("%d", &N);
	User_ctrl = (ctrl*)malloc(sizeof(ctrl) * N);
	i = 0;
	while (i<N) {
		scanf("%d %c", &((User_ctrl + i)->time), &((User_ctrl + i)->dir));
		getchar();
		i++;
	}

	input(&head, &rear, X, Y);

	i = 0;
	while (1) {
		time++;
		if (time == (User_ctrl + i)->time && i < N) {
			if ((User_ctrl + i)->dir == 'D' && dir == RIGHT)
				dir = DOWN;
			else if ((User_ctrl + i)->dir == 'L' && dir == RIGHT)
				dir = UP;
			else if ((User_ctrl + i)->dir == 'D' && dir == UP) 
				dir = RIGHT;
			else if ((User_ctrl + i)->dir == 'L' && dir == UP) 
				dir = LEFT;
			else if ((User_ctrl + i)->dir == 'D' && dir == LEFT) 
				dir = UP;
			else if ((User_ctrl + i)->dir == 'L' && dir == LEFT) 
				dir = DOWN;
			else if ((User_ctrl + i)->dir == 'D' && dir == DOWN) 
				dir = LEFT;
			else if ((User_ctrl + i)->dir == 'L' && dir == DOWN) 
				dir = RIGHT;
			i++;
		}

		if (dir == RIGHT) 
			Y++;
		else if (dir == LEFT) 
			Y--;
		else if (dir == DOWN) 
			X++;
		else 
			X--;
		input(&head, &rear, X, Y);



		if (rear->X > board || rear->Y > board || rear->X < 1 || rear->Y < 1 || same_XY(&head, &rear) == 1) {
			break;
		}


		for (j = 0; j < EA; j++) {
			if ((apple + j)->X == X && (apple + j)->Y == Y) {
				(apple + j)->X = -1;
				break;
			}
    	}
		if (j == EA) {
			pop(&head,&rear);
		}

	}

	printf("%d", time+1);
}
//<input.txt>output.txt