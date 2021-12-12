                                             Traveling-Salesman-Problem-With-Genetic-Algorithm
 
 
 1. Genetic Algorithm Approach
    Used Java programming language when I developed my Genetic Algorithm. First, I read my data from txt file. After that, I create a city class for keeping my city x and y coordinates     and their names. And I sent these cities to a list structure. At that moment I need a random order for TSP problem. So that reason I use shuffle method of list structure. Now I have     a path. In my program paths calls solution and I create a solution class for keep paths information and related methods.
    For initialize a population, I set the size of population 100. And I calculate fitness value of all solutions.
    
2. Chosen Genetic Algorithm Methods

    Crossover Technique
    
    In my crossover function I chose a method shows as upper picture. First, I determine two solutions (parents) that have the best path in our population. After that I choose randomly two elements in second parent’s elements. For the first step I should determine the position of parent2’s chosen element in parent1. After the determine operation, I swap these two value that first one the same position with parent2’s chosen element and second one the include the same value parent2’s
chosen element. By this method I don’t have to do any uniqueness control on my children.
Because I already provide that. For the other chosen element, we do same steps. After all these steps we have a brand-new child. For the parent2 this time we choose elements randomly from parent1 and we check these elements in parent2. After all operation we have a two different child

![resim](https://user-images.githubusercontent.com/41449476/145710594-7736df74-35db-481d-b182-f565d2e772f4.png)

  Mutation Technique
  
  In mutation operation I choose reverse mutation technique. I determine randomly two number and I reverse all list elements between these two points. But there is a critical point. My random numbers never be my start point. If I don’t determine this condition my algorithm would work completely wrong.
  
  ![resim](https://user-images.githubusercontent.com/41449476/145710690-222f9d8f-0e9c-404e-9ac6-385b7fb74019.png)
