/*
 -------------------------------------------------
 BOOK ALLOCATION PROBLEM
 -------------------------------------------------
 Problem:
 Allocate books among m students such that:

 1. Each student gets at least one book
 2. Books are allocated in contiguous order
 3. A book cannot be divided
 4. Minimize the maximum pages assigned

 -------------------------------------------------
 BINARY SEARCH ON ANSWER
 -------------------------------------------------

 We binary search on:
 "maximum pages allowed to a student"

 Range:
    low  = maximum book pages  (Answer cannot be smaller than largest book)
    high = sum of all pages    (Answer cannot be greater than total sum)

 If a value 'mid' is valid,then every value greater than mid will also be valid.
This monotonic property allows Binary Search.

 -------------------------------------------------
 HOW VALIDATION WORKS
 -------------------------------------------------
 For every mid:
   Try allocating books sequentially. If current student exceeds no of students ,allocate next book to new student.
   Count how many students are needed.

 If students <= m:
     allocation is possible try smaller answer=>high=mid-1;

 Else:
     allocation not possible increase limit=>low=mid+1;

 TIME COMPLEXITY:O(N * log(sum))


**/
package BinarySearch.answers;

public class BookAllocationProblem {
	
	//method to count no of student for given limit of pages 
	static int countStudents(int[] books, int limit) {
		
		int students = 1;
		int pages = 0;
		
		for (int i = 0; i < books.length; i++) {
			
			// add current book
			if (pages + books[i] <= limit) {
				pages += books[i];
			}
			
			// allocate to next student
			else {
				students++;
				pages = books[i];
			}
		}
		
		return students;
	}
	
	// -------------------------------------------------
	// Main allocation function
	// -------------------------------------------------
	static int allocateBooks(int[] books, int m) {
		
		int n = books.length;
		
		// impossible case
		if (m > n)
			return -1;
		
		//deciding range of queries
		int low = books[0];
		int high = 0;
		
		// find max and sum
		for (int i = 0; i < n; i++) {
			low = Math.max(low, books[i]);//a student must have atleast 1 book ,thats why it should hold the max no of pages 
			high += books[i];   //to hold the possible max no of pages 1 student can take 
		}
		
		int ans = -1;
		
		// binary search on answer
		while (low <= high) {
			
			int mid = low + (high - low) / 2;
			int students = countStudents(books, mid);
			
			// valid allocation
			if (students <= m) {
				ans = mid;
				high = mid - 1;
			}
			// need more students
			else {
				low = mid + 1;
			}
		}
		
		return ans;//or we can simply return low 
	}
	
	// -------------------------------------------------
	// Main method
	// -------------------------------------------------
	public static void main(String[] args) {
		
		int[] books = {12, 34, 67, 90};
		int students = 2;
		
		int result = allocateBooks(books, students);
		
		System.out.println("Minimum possible maximum pages = " + result);
	}
	

}

