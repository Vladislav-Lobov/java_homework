// Задача 002 от 16 декабря 2022 года (4 семинар)

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.
// (Подобную задачу решали на семинаре. Здесь так же нужно создать класс, 
// который будет реализовывать указанные методы)

public class j20221216_homework02 {

    public static void main(String[] args) {

        j20221216_MyQueueClass queue = new j20221216_MyQueueClass();
        queue.enqueue("Казань");
        queue.enqueue("Ростов-на-Дону");
        queue.enqueue("Краснодар");
        queue.enqueue("Ярославль");
        queue.enqueue("Пермь");
        System.out.println("Результат работы нескольких вызовов enqueue(): " + queue.myQueueFromClass);
        System.out.println("Вызов dequeue(): " + queue.dequeue());
        System.out.println("Результат работы dequeue(): " + queue.myQueueFromClass);
        System.out.println("Вызов dequeue(): " + queue.dequeue());
        System.out.println("Результат работы dequeue(): " + queue.myQueueFromClass);
        System.out.println("Вызов first(): " + queue.first());
        System.out.println("Результат работы first(): " + queue.myQueueFromClass);

    }

}
