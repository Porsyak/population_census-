import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Оля", "Коля", "Толя", "Света", "Ваня", "Таня", "Паша", "Михаил", "Александр");
        List<String> families = Arrays.asList("Иванов", "Кузнецов", "Воробьев", "Чижиков", "Николаев", "Артамонов", "Захаров");
        Collection<Person> people = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            people.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }
        long list1 = people.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(list1);

        Stream<Person> stream = people.stream();
        List<String> list2 =
                stream
                        .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                        .filter(person -> person.getSex().equals(Sex.MAN))
                        .map(Person::getName)
                        .toList();
        System.out.println(list2.size());

        Stream<Person> personStream = people.stream();
        List<String> listWorkMan =
                personStream
                        .filter(person -> person.getAge() >= 18 && person.getAge() <= 65)
                        .filter(person -> person.getSex().equals(Sex.MAN))
                        .filter(person -> person.getEducation().equals(Education.HIGHER))
                        .map(Person::getName)
                        .toList();

        Stream<Person> personStream1 = people.stream();
        List<String> listWorkWomen =
                personStream1
                        .filter(person -> person.getAge() >= 18 && person.getAge() <= 60)
                        .filter(person -> person.getSex().equals(Sex.WOMAN))
                        .filter(person -> person.getEducation().equals(Education.HIGHER))
                        .map(Person::getName)
                        .toList();

        List<String> workPeople = new ArrayList<>();
        workPeople.addAll(listWorkMan);
        workPeople.addAll(listWorkWomen);
        System.out.println(workPeople.size());


    }


}


