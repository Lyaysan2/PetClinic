package ru.itis.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TimeSlotGenerator {
    public static void main(String[] args) throws IOException {
        List<String> doctorsUUID = Arrays.asList(
                "652ae5f7-835b-0dff-c75a-f40d0528d8df", "92489495-c109-49a6-c328-cc4171963415",
                "ed8be668-237c-41b8-965f-153c4fd61f5a", "3a60f97b-13b1-c6f4-44d4-a16562323c83",
                "fe8b2986-a1e0-4a97-0adf-b343099b7a78", "c74c7f5c-e6f2-e4b2-8810-254362dc164d",
                "03f5ce5c-5de0-1b8b-18ef-5951207b718b", "72401ff9-a6c5-8f1c-bc40-59a3a6ac0bf5",
                "9bc6bcfe-9c5a-aa77-3c88-5af938a92a7a", "35de65a4-8c35-52d1-ecc5-2deab65884b0",
                "38f90591-b364-052c-841f-3f3e1f1f85ea", "223327d4-c863-500b-a93e-fd02babc9f4a",
                "440f6ebd-5b34-0e7a-cdd9-7c9d6b045ac5", "53ba0b1d-3b24-89cc-3793-d3b10bf98c4b",
                "a2d0ab23-9ad2-689e-2294-ea907ad7d933", "33471533-2b0b-5cf0-bed7-5b2daffe2247",
                "0bef5c91-6103-23e8-3b61-053bfbc9bbf8", "84cae541-bd12-8f17-b8b2-1a51322d0423");

        FileWriter fileWriter = new FileWriter("2023-05-02_insert_time_slots.sql");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 6, 8, 0);
        for (LocalDateTime d = dateTime; d.isBefore(dateTime.plusDays(30)); d = d.plusDays(1)) {
            for (LocalDateTime t = d; t.isBefore(d.plusHours(12)); t = t.plusHours(1)) {
                if (Integer.parseInt(t.format(DateTimeFormatter.ofPattern("H"))) < 13) {
                    for (int i = 0; i < doctorsUUID.size(); i += 2) {
                        printWriter.print(String.format("insert into time_slot(date, start_time, end_time, " +
                                        "is_booked, doctor_id) VALUES ('%s', '%s', '%s', false, '%s');%n",
                                t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                t.plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                doctorsUUID.get(i)));
                    }
                } else {
                    for (int i = 1; i < doctorsUUID.size(); i += 2) {
                        printWriter.print(String.format("insert into time_slot(date, start_time, end_time, " +
                                        "is_booked, doctor_id) VALUES ('%s', '%s', '%s', false, '%s');%n",
                                t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                t.plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                doctorsUUID.get(i)));
                    }
                }
            }
        }
        fileWriter.close();
    }
}
