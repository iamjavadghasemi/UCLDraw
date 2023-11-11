public class List {
    private Node head = null;
    private int length = 0;
    public int getLength() {
        return length;
    }
    public void insert(Club club) {
        Node node = new Node(club, null);
        node.setNext(head);
        head = node;
        length++;
    }
    public Club find(int number) {
        Node pointer = head;
        int counter = 0;
        while(pointer != null) {
            if(counter == number) {
                return pointer.getClub();
            }
            pointer = pointer.getNext();
            counter++;
        }
        return null;
    }
    public Club remove(int number) {
        Node pointer = head, sample = null;
        int counter = 0;
        Club club;
        while(pointer != null) {
            if(counter == number) {
                club = pointer.getClub();
                if(pointer == head && pointer.getNext() == null) {
                    head = null;
                } else if(pointer == head) {
                    head = head.getNext();
                } else if(pointer.getNext() == null) {
                    sample.setNext(null);
                } else {
                    sample.setNext(pointer.getNext());
                }
                length--;
                return club;
            }
            sample = pointer;
            pointer = pointer.getNext();
            counter++;
        }
        return null;
    }
}