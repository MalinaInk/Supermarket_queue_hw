import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class QueueMarket {
    private static final int MAX_SIZE = 5;
    private static final List<String> NAMES = List.of(
            "Иван Иванов",
            "Петр Петров",
            "Николай Николаев",
            "Алексей Иванов",
            "Мария Сидорова",
            "Глеб Михайлов",
            "Михаил Петров",
            "Иван Петров",
            "Петр Иванов",
            "Дмитрий Дмитриев"
    );

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>(); //создаем 2 очереди
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1); //заполняем
        randomFilling(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);

        add("Владимир Петров", queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);

        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);

    }

    //новый добавляется в наименьшую очередь. если заполнены обе - зовем Галю
    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Нужно позвать Галю!");
            return;
        }

        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    //метод, удаляющий человека из случайной очереди
    private static void remove(Queue<String> queue1,
                               Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static void randomFilling(java.util.Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE+1);//максимально 5 человек, случайное число итераций в пределах 5
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
//           заполняем очередь из 6 человек -> получить случайный индекс из листа NAMES 1-5 раз
        }
    }
}
