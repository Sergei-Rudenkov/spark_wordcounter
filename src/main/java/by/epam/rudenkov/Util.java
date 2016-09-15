package by.epam.rudenkov;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Created by sergei-rudenkov on 15.9.16.
 */
public class Util {
    public static Iterator<String> getWord(String line) {
        return Arrays.asList(line.split("\\W+")).iterator();
    }

    public static Collection<String> readDirRecursively(String dir, String filter){
        return FileUtils.listFiles(
                new File(dir),
                new RegexFileFilter(filter),
                DirectoryFileFilter.DIRECTORY
        ).stream().map(file -> file.toString()).collect(Collectors.toList());
    }

}
