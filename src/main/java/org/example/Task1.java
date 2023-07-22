package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/*
Написать функцию,
создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
 */

public class Task1 {
    public static void main(String[] args) {


        String sourceDir = "/Geekbrains/Block3/JavaCore/Seminar5/Hw5";
        String backupDir = "backup";

        try {
            createBackup(sourceDir, backupDir);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static void createBackup(String sourceDir, String backupDir) throws IOException {
        File sourceDirectory = new File(sourceDir);
        File backupDirectory = new File(backupDir);
        if (sourceDirectory.exists() && sourceDirectory.isDirectory()) {
            if (!backupDirectory.exists() && !backupDirectory.mkdir()) {
                System.err.println("Не удалось создать папку для резервных копий.");
            } else {
                File[] files = sourceDirectory.listFiles();
                if (files != null) {
                    File[] var5 = files;
                    int var6 = files.length;

                    for(int var7 = 0; var7 < var6; ++var7) {
                        File file = var5[var7];
                        if (file.isFile()) {
                            File backupFile = new File(backupDirectory, file.getName());
                            Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Создана резервная копия файла: " + backupFile.getAbsolutePath());
                        }
                    }

                    System.out.println("Резервные копии созданы успешно!");
                } else {
                    System.err.println("Ошибка при получении списка файлов из исходной директории.");
                }

            }
        } else {
            System.err.println("Исходная директория не существует или не является директорией.");
        }
    }
    }
