import java.util.Stack;

public class Sort {
    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void insertSort(int[] array, int left,int right) {
        for (int i = left+1; i <= right; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= left; j--) {
                //这里加不加等号 和稳定有关系
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shell(array,gap);
        }
    }
    /**
     * 对每组进行插入排序
     * @param array
     * @param gap
     */
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    /**
     *选择排序
     */
    public static void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
                //走完后min指向最小值下标
            }
            swap(array,minIndex, i);
        }
    }

    public static void selectSort2(int[] array) {
        int left = 0, right = array.length-1;
        while (left < right) {
            int minIndex = left, maxIndex = left;
            for (int i = left+1; i <= right; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if(array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            //这一次for循环走完之后
            swap(array,left,minIndex);
            if(maxIndex == left) maxIndex = minIndex;
            swap(array,right,maxIndex);

            right--;
            left++;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

   private static void createHeap(int[] array) {
        //创建大根堆要从最后一棵子树开始调整，注意是子树而不是叶
       for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
           siftDown(array,0,array.length);
       }
   }

    private static void siftDown(int[] array,int parent, int length) {
        int child = 2*parent+1;
        // 这个while条件是至少有一个孩子，child如果大于len就是null
        while (child < length) {
            if(child + 1 <length && array[child] < array[child+1]) {
                //这个if说明有右孩子并且右孩子比左孩子小
                child++;//child++后就是指向的右孩子,也就是说，这个if走完之后，child指向的就是最大孩子
            }
            if(array[child] > array[parent]) {
                //最大孩子比parent大
                swap(array,parent,child);
                // 调整完之后要更新parent和child的值
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;
        while (end > 0) {
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
   }

   public static void bubbleSort(int[] array) {
       for (int i = 0; i < array.length - 1; i++) {
           //j 来比较每个数据的大小
           boolean flg = false;
           for (int j = 0; j < array.length - 1 - i; j++) {
               if(array[j] > array[j+1]) {
                   swap(array,j,j+1);
                   flg = true;
               }
           }
           if(!flg) {
               break;
           }
       }
   }

    /**
     * 快排
     * @param array
     */
   public static void quickSort(int[] array) {
       quick(array, 0, array.length-1);
   }

   private static void quick(int[] array, int start, int end) {
       if(start >= end) {
           return;
       }
       if(end - start+1 < 15) {
           insertSort(array,start,end);
           return;
       }
       int index = middleNum(array,start,end);
       swap(array,index,start);
       //中间数法
       int pivot = partitionHoare(array,start,end);
       quick(array,start,pivot-1);
       quick(array,pivot+1,end);
   }

   public static void quickSortNor(int[] array) {
       int start = 0;
       int end = array.length-1;
       Stack<Integer> stack = new Stack<>();
       int pivot = partitionHoare(array,start,end);
       if(pivot-1 > start) {
           //说明左边有两个元素需要放进栈
           stack.push(start);
           stack.push(pivot-1);
       }
       if(pivot+1 < end) {
           stack.push(pivot+1);
           stack.push(end);
       }
       while(!stack.isEmpty()) {
           end = stack.pop();
           start = stack.pop();
           pivot = partitionHoare(array, start, end);
           if(pivot-1 > start) {
               //说明左边有两个元素需要放进栈
               stack.push(start);
               stack.push(pivot-1);
           }
           if(pivot+1 < end) {
               stack.push(pivot+1);
               stack.push(end);
           }
       }

   }

//   private static int partitionHoare(int[] array, int left, int right) {
//       int tmp = array[left];
//       int i = left;
//       while (left < right) {
//           //循环内的单词循环不可以越界
//           while (left < right && array[left] <= tmp) left++;
//
//           while (left < right && array[right] >= tmp) right--;
//           //这里走完后
//           swap(array,right,left);
//
//       }
//       //走出大循环，tmp改变
//       swap(array,i,left);
//
//       return left;
//   }

    private static int partitionHoare(int[] array, int left, int right) {
       int pivot = array[left];
       int i = left;
       int j = right;

       while (i < j) {
           while (i < j && array[j] >= pivot) {
               j--;
           }
           while (i < j && array[i] <= pivot) {
               i++;
           }
           if(i < j) {
               swap(array,i,j);
           }
       }
       swap(array,left,i);
       return i;
    }

    private static int partitionHole(int[] array, int left, int right) {
       int tmp = array[left];

       while (left < right) {
           while (left < right && array[right] >= tmp) {
               right--;
           }
           array[left] = array[right];

           while (left > right && array[left] <= tmp) {
               left++;
           }
           array[right] = array[left];
       }
       array[left] = tmp;
       return left;
    }
    /**
     * 前后指针法
     * 总结：
     * 1. Hoare
     * 2. 挖坑法
     * 3. 前后指针法
     */
    //=======================================================================

    /**
     * 求中位数的下标
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int middleNum(int[] array, int left ,int right) {
        int mid = (left + right)/2;
        if(array[left] < array[right]) {
            if(array[mid] < array[left]) {
                return left;
            }else if(array[mid] > array[right]) {
                return right;
            }
            else return mid;

        }else {
            if(array[mid] < array[right]) {
                return right;
            }else if(array[mid] > array[left]) {
                return left;
            }
            else return mid;
        }
    }


    public static void mergeSort(int[] array) {
        mergeSortFun(array,0,array.length-1);
    }

    private static void mergeSortFun(int[] array, int start, int end) {
        if(start >= end) {
            //递归的结束条件
            return;
        }
        int mid = (start+end)/2;
        //分解
        mergeSortFun(array,start,mid);
        mergeSortFun(array,mid+1,end);
        //合并
        merge(array,start,mid,end);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int[] tmpArr = new int[right-left+1];
        int k = 0;//tmpArr的下标
        while (s1 <= e1 && s2 <= e2) {
            //两个归并段都有数据
            if(array[s1] <= array[s2]) {
                tmpArr[k++] = array[s1++];
            }else {
                tmpArr[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = array[s2++];
        }

        //把排好序的数组拷贝回原来的array中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i+left] = tmpArr[i];
        }
    }
    public static void mergeSortNor(int[] array) {

        int gap = 1;//每组几个数据
        while (gap < array.length) {

            for (int i = 0; i < array.length; i+=(gap*2)) {
                int left = i;
                int mid = left + gap-1;
                int right = mid + gap;
                //如果越界，所以条件是》=array。legth
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                if(right >= array.length) {
                    right = array.length-1;
                }
                merge(array,left,mid,right);
            }

            gap *= 2;
        }
    }

    public static void countSort(int[] array) {
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
            if(array[i] < minVal) {
                minVal = array[0];
            }
        }
        int[] count = new int[maxVal-minVal+1];
        //遍历array数组，存储数据出现次数
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minVal]++;
        }
        int index = 0;
        //需要遍历count数组，把实际数据写回array数组
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
               array[index] = i + minVal;
               index++;
               count[i]--;
            }
        }
    }
}
