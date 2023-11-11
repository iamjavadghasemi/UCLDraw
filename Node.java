public class Node {
    private Club club;
    private Node next;
    public Node(Club club, Node next) {
        this.club = club;
        this.next = next;
    }
    public Club getClub() {
        return club;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
}