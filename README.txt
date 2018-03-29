@Maria Fãtu

Ex1:Plants
For this exercise, I chose to store the labeled an unlabeled plants in one matrix(Nx3 and Mx3 dimension) each.
The first column would represent the RED code,the second the GREEN one and the last would be for the BLUE one in both matrices.
For storing the value of the similarity results I used a single array which will be overwritten for each unlabeled plant.
The sorting of the first k elements from the similarity array is done using selection sort.
In the sorting method, firstly , I store the original state of the types array because it will be later altered in the process of sorting the similarity array and its type array accordingly. I go through the similarity array element by element until I have all the k similarity scores and types in the right order. After this, i give back to the type array the original state so that it can be used for the next unlabeled plant. 
The complexity for this one is n*m*k*n.

Ex2:Madripoor
For this exercise,I have a matrix for the distances of dimension NxN which I populate as I am reading the input.The distances matrix is filled according to the case, if I encounter a ’#’ I put -2 in the distances matrix , for the ’P’ case, I put a 0 in the distances matrix, I add the coordinates of the guard in a queue which will be used later and change the ’countP’ variable, meaning that we have at least one guard, so that it makes sense to apply a BFS algorithm on the matrix. If we’re not found in any of theese cases, we populate the matrix of distances with -1.
After populating the two matrices, we verify if there are any guards and if the answer is yes, we apply the BFS algorithm for each guard.
In the ”solveBFS ” function, I take as parameters, the distance matrix, the queue initially filled with guards , the last guard’s coordinates and the size of the matrix. I have two arrays which indicate the four directions in which a current coordinate can go (up,down,left and right) and four integers for storing the current location and the neighbours’ locations. After that, as the queue is not empty, we extract the coordinates of the current x and y and then, for each direction we take the neighbours and then verifiy if there can be a smaller distance between the current and the neighbour node. If the answer is yes, we change the value for the neighbour node to the one of the current plus one and then add the coordinates of that neighbour to the queue.
The complexity is n^2.

