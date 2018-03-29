# LongestCommonSubseq-LCS-


I chose to store the labeled an unlabeled plants in one matrix(Nx3 and Mx3 dimension) each.
The first column would represent the RED code,the second the GREEN one and the last would be for the BLUE one in both matrices.
For storing the value of the similarity results I used a single array which will be overwritten for each unlabeled plant.
The sorting of the first k elements from the similarity array is done using selection sort.
In the sorting method, firstly , I store the original state of the types array because it will be later altered in the process of sorting the similarity array and its type array accordingly. I go through the similarity array element by element until I have all the k similarity scores and types in the right order. After this, i give back to the type array the original state so that it can be used for the next unlabeled plant. 
The complexity for this one is n*m*k*n.
