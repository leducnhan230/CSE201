package groupProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    
    // Lớp đại diện cho một môn học
    static class Course {
        String id;
        int credits;
        int longestPath = 0; // Độ dài đường găng (số cạnh tối đa đến đỉnh đích)
        int inDegree = 0;    // Bậc vào phục vụ cho thuật toán Kahn
        List<Course> nextCourses = new ArrayList<>(); // Các môn học cần môn này làm tiên quyết

        public Course(String id, int credits) {
            this.id = id;
            this.credits = credits;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstLine = reader.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) return;

            String[] tokens = firstLine.trim().split("\\s+");
            int N = Integer.parseInt(tokens[0]);
            int M = Integer.parseInt(tokens[1]);
            int S = Integer.parseInt(tokens[2]);
            int MaxC = Integer.parseInt(tokens[3]);

            Map<String, Course> courseMap = new HashMap<>();
            List<Course> allCourses = new ArrayList<>();

            // 1. Đọc danh sách môn học
            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                if (line == null) break;
                String[] parts = line.trim().split("\\s+");
                String id = parts[0];
                int credits = Integer.parseInt(parts[1]);
                Course c = new Course(id, credits);
                courseMap.put(id, c);
                allCourses.add(c);
            }

            // 2. Đọc danh sách các mối quan hệ tiên quyết (Cạnh đồ thị)
            for (int i = 0; i < M; i++) {
                String line = reader.readLine();
                if (line == null) break;
                String[] parts = line.trim().split("\\s+");
                String uId = parts[0];
                String vId = parts[1];
                
                Course u = courseMap.get(uId);
                Course v = courseMap.get(vId);
                
                if (u != null && v != null) {
                    u.nextCourses.add(v);
                    v.inDegree++;
                }
            }

            // 3. Kiểm tra chu trình và Tính Sắp xếp Tô-pô ngược bằng thuật toán Kahn để tìm Đường găng
            // Khởi tạo hàng đợi chứa các đỉnh có Out-degree = 0 để tính toán Đường găng từ dưới lên
            // Ta đếm bậc ra ngược hoặc chỉ đơn giản là tính toán độ dài đường găng bằng Memoization (Quy hoạch động/DFS)
            if (hasCycleAndCalculatePaths(allCourses)) {
                System.out.println("ERROR: INVALID CURRICULUM");
                return;
            }

            // 4. Tiến hành xếp lịch học tập theo thuật toán Tham lam phối hợp Hàng đợi ưu tiên
            // Định nghĩa bộ so sánh (Comparator) cho Hàng đợi ưu tiên:
            // - Ưu tiên 1: longestPath lớn hơn xếp trước (Đường găng dài hơn)
            // - Ưu tiên 2: Thứ tự từ điển của CourseID nhỏ hơn xếp trước
            PriorityQueue<Course> availableQueue = new PriorityQueue<>((c1, c2) -> {
                if (c2.longestPath != c1.longestPath) {
                    return Integer.compare(c2.longestPath, c1.longestPath);
                }
                return c1.id.compareTo(c2.id);
            });

            // Đưa các môn học không có môn tiên quyết (inDegree == 0) vào hàng đợi ban đầu
            for (Course c : allCourses) {
                if (c.inDegree == 0) {
                    availableQueue.add(c);
                }
            }

            List<String> scheduleOutput = new ArrayList<>();
            int currentSemester = 0;
            int totalProcessedCourses = 0;

            // Vòng lặp xếp lịch theo từng học kỳ
            while (!availableQueue.isEmpty()) {
                currentSemester++;
                int currentCredits = 0;
                List<Course> skippedCourses = new ArrayList<>();
                List<String> coursesInThisSemester = new ArrayList<>();

                // Thử lấp đầy học kỳ hiện tại
                while (!availableQueue.isEmpty()) {
                    Course currentCourse = availableQueue.poll();

                    // Kiểm tra nếu thêm môn này vào có bị quá tải tín chỉ không
                    if (currentCredits + currentCourse.credits <= MaxC) {
                        currentCredits += currentCourse.credits;
                        coursesInThisSemester.add(currentCourse.id);
                        totalProcessedCourses++;
                        
                        // Cập nhật các môn học tiếp theo sau khi môn này hoàn thành
                        for (Course next : currentCourse.nextCourses) {
                            next.inDegree--;
                            if (next.inDegree == 0) {
                                skippedCourses.add(next); // Tạm giữ để đẩy vào hàng đợi ở cuối kỳ
                            }
                        }
                    } else {
                        // Nếu không vừa, giữ lại môn này cho học kỳ sau
                        skippedCourses.add(currentCourse);
                    }
                }

                // Trả lại các môn bị bỏ qua và các môn mới mở khóa vào lại Hàng đợi ưu tiên cho kỳ kế tiếp
                availableQueue.addAll(skippedCourses);

                // Lưu lại kết quả định dạng của học kỳ này
                StringBuilder sb = new StringBuilder();
                sb.append("SEMESTER ").append(currentSemester).append(": ");
                for (int i = 0; i < coursesInThisSemester.size(); i++) {
                    sb.append(coursesInThisSemester.get(i));
                    if (i < coursesInThisSemester.size() - 1) sb.append(" ");
                }
                sb.append(" - TOTAL: ").append(currentCredits).append(" CREDITS");
                scheduleOutput.add(sb.toString());
            }

            // 5. Kiểm tra kết quả đầu ra dựa trên số học kỳ mục tiêu S
            if (currentSemester <= S) {
                for (String semesterLine : scheduleOutput) {
                    System.out.println(semesterLine);
                }
                System.out.println("STATUS: GRADUATED ON TIME");
            } else {
                System.out.println("IMPOSSIBLE: NEEDS MINIMUM " + currentSemester + " SEMESTERS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm kiểm tra chu trình bằng thuật toán Kahn và tính độ dài đường găng lớn nhất cho mỗi đỉnh
    private static boolean hasCycleAndCalculatePaths(List<Course> allCourses) {
        int n = allCourses.size();
        // Sao lưu bậc vào để làm thuật toán Kahn kiểm tra chu trình độc lập
        int[] tempInDegree = new int[n];
        Map<Course, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tempInDegree[i] = allCourses.get(i).inDegree;
            indexMap.put(allCourses.get(i), i);
        }

        Queue<Course> kahnQueue = new LinkedList<>();
        for (Course c : allCourses) {
            if (c.inDegree == 0) kahnQueue.add(c);
        }

        int visitedCount = 0;
        while (!kahnQueue.isEmpty()) {
            Course u = kahnQueue.poll();
            visitedCount++;
            for (Course v : u.nextCourses) {
                int idx = indexMap.get(v);
                tempInDegree[idx]--;
                if (tempInDegree[idx] == 0) {
                    kahnQueue.add(v);
                }
            }
        }

        // Nếu số đỉnh duyệt được nhỏ hơn N tức là đồ thị tồn tại chu trình vòng lặp
        if (visitedCount < n) return true;

        // Nếu đồ thị hợp lệ (DAG), tính toán đường găng (longest path) bằng DFS + Memoization
        Map<Course, Integer> memo = new HashMap<>();
        for (Course c : allCourses) {
            calculateLongestPath(c, memo);
        }
        return false;
    }

    // Hàm đệ quy Quy hoạch động/DFS để tính chuỗi liên tiếp dài nhất từ đỉnh hiện tại đến đích
    private static int calculateLongestPath(Course c, Map<Course, Integer> memo) {
        if (memo.containsKey(c)) return memo.get(c);
        
        int maxLen = 0;
        for (Course next : c.nextCourses) {
            maxLen = Math.max(maxLen, 1 + calculateLongestPath(next, memo));
        }
        
        c.longestPath = maxLen;
        memo.put(c, maxLen);
        return maxLen;
    }
}