package programmers.LV2.메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    // course 음식코스, occurrences
    private static class Course{
        String course;
        int occurrences;

        Course(String course, int occurrences){
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    private void getCourse(char nextMenu, Set<String> selectMenus, List<Set<String>> orderList, Map<Integer, List<Course>> courses) {
        int occurrences = (int)orderList.stream().filter(order -> order.containsAll(selectMenus)).count();

        if(occurrences < 2) return;

        int size = selectMenus.size();
        if(courses.containsKey(size)){
            List<Course> courseList = courses.get(size);
            Course course = new Course(selectMenus.stream().sorted().collect(Collectors.joining("")), occurrences);

            Course original = courseList.get(0);
            if(original.occurrences < course.occurrences){
                courseList.clear();
                courseList.add(course);
            }else if(original.occurrences == course.occurrences){
                courseList.add(course);
            }
        }

        if(size >= 10) return;

        for(char menuChar = nextMenu; menuChar <= 'Z'; menuChar++){
            String menu = String.valueOf(menuChar);
            selectMenus.add(menu);
            getCourse((char) (menuChar + 1), selectMenus, orderList, courses);
            selectMenus.remove(menu);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        // [ABCD, BEE, CAA] => [[A, B, C, D], [B, E, E], [C, A, A]];

        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream.mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>();
        for(int length : course){
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }

        getCourse('A', new HashSet<>(), orderList, courses);
        return courses.values().stream().filter(list -> list.get(0).occurrences > 0).flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }
}