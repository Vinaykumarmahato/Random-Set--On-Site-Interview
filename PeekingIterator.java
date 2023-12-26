import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> nums) {
        this.iterator = nums;
        this.nextElement = nums.hasNext() ? nums.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // Returns the next element in the iteration and advances the iterator.
    @Override
    public Integer next() {
        Integer result = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    // Returns true if the iteration has more elements.
    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage:
        Iterator<Integer> nums = List.of(1, 2, 3).iterator();
        PeekingIterator peekingIterator = new PeekingIterator(nums);

        System.out.println(peekingIterator.next());    // Output: 1
        System.out.println(peekingIterator.peek());    // Output: 2
        System.out.println(peekingIterator.next());    // Output: 2
        System.out.println(peekingIterator.next());    // Output: 3
        System.out.println(peekingIterator.hasNext()); // Output: false
    }
}
