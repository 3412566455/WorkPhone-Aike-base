package c.t;

import android.view.View;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AbstractC1360kB {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    public static final int[] b = {2, 1, 4, 3};

    public static /* synthetic */ String A(int i) {
        return i == 1 ? "INITIALIZE" : i == 2 ? "RESOURCE_CACHE" : i == 3 ? "DATA_CACHE" : i == 4 ? "SOURCE" : i == 5 ? "ENCODE" : i == 6 ? "FINISHED" : "null";
    }

    public static /* synthetic */ String B(int i) {
        return i == 1 ? "SOURCE" : i == 2 ? "TRANSFORMED" : i == 3 ? "NONE" : "null";
    }

    public static /* synthetic */ int[] C(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }

    public static int[] _values() {
        return C(11);
    }

    public static /* synthetic */ int a(int i) {
        if (i == 1) {
            return -10000;
        }
        if (i == 2) {
            return 10000;
        }
        if (i == 3) {
            return 10001;
        }
        if (i == 4) {
            return 10002;
        }
        if (i == 5) {
            return 10003;
        }
        if (i == 6) {
            return 20000;
        }
        if (i == 7) {
            return 20001;
        }
        if (i == 8) {
            return 20002;
        }
        if (i == 9) {
            return 20003;
        }
        if (i == 10) {
            return 30000;
        }
        if (i == 11) {
            return 30001;
        }
        throw null;
    }

    public static /* synthetic */ boolean b(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static /* synthetic */ String c(int i) {
        if (i == 1) {
            return "File {0} being read";
        }
        if (i == 2) {
            return "This file does not appear to be an Mp4  file";
        }
        if (i == 3) {
            return "This file does not appear to be an Mp4 Audio file, could be corrupted or video ";
        }
        if (i == 4) {
            return "This file appears to be an Mp4 Video file, video files are not supported ";
        }
        if (i == 5) {
            return "Unable to safetly check consistency in Mp4 file so cancelling save";
        }
        if (i == 6) {
            return "File contains multiple data atoms";
        }
        if (i == 7) {
            return "Unable to make changes to Mp4 file";
        }
        if (i == 8) {
            return "Unable to make changes to Mp4 file, no data was written";
        }
        if (i == 9) {
            return "Unable to make changes to Mp4 file, invalid data length has been written";
        }
        if (i == 10) {
            return "Unable to make changes to Mp4 file, no tag data has been written";
        }
        if (i == 11) {
            return "Unable to make changes to Mp4 file, incorrect offsets written difference was {0}";
        }
        if (i == 12) {
            return "Unable to make changes to Mp4 file, unable to determine start of audio";
        }
        if (i == 13) {
            return "Flac Header not found, not a flac file";
        }
        if (i == 14) {
            return "Cannot find vorbis setup parentHeader";
        }
        if (i == 15) {
            return "Reverse dns field:{0} has no data";
        }
        if (i == 16) {
            return "Unable to create reverse dns field because of exception:{0} adding as binary data instead";
        }
        if (i == 17) {
            return "The OGG Stream is not valid, Vorbis tag valid framing bit is wrong {0} ";
        }
        if (i == 18) {
            return "Cannot make changes to file {0}";
        }
        if (i == 19) {
            return "Cannot make changes to file {0} because it is being used by another application";
        }
        if (i == 20) {
            return "Cannot make changes to file {0} because too small to be an audio file";
        }
        if (i == 21) {
            return "Cannot make changes to file {0} because unable to delete the original file ready for updating from temporary file {1}";
        }
        if (i == 22) {
            return "Cannot make changes to file {0} because unable to rename from temporary file {1}";
        }
        if (i == 23) {
            return "Cannot make changes to file {0} because unable to rename the original file to {1}";
        }
        if (i == 24) {
            return "Unable to rename backup {0} back to file {1}";
        }
        if (i == 25) {
            return "New file {0} does not appear to exist";
        }
        if (i == 26) {
            return "Cannot make changes to file {0} because {1}";
        }
        if (i == 27) {
            return "Cannot make changes to file {0} because the file cannot be found";
        }
        if (i == 28) {
            return "Unable to delete the backup file {0}";
        }
        if (i == 29) {
            return "Problem closing file handles for file {0} because {1}";
        }
        if (i == 30) {
            return "Cannot delete file {0}";
        }
        if (i == 31) {
            return "Cannot delete file {0} because it is being used by another application";
        }
        if (i == 32) {
            return "Cannot write to file {0} because too small to be an audio file";
        }
        if (i == 33) {
            return " {0}:Checking further because the ID3 Tag ends at {1} but the mp3 audio doesnt start until {2}";
        }
        if (i == 34) {
            return "{0}: Recalculated possible start of the audio to be at {1}";
        }
        if (i == 35) {
            return "{0}: Recalculated the start of the audio to be at {1}";
        }
        if (i == 36) {
            return "{0}: Confirmed audio starts at {1} whether searching from start or from end of ID3 tag";
        }
        if (i == 37) {
            return "Url:{0} saved in encoded form as {1}";
        }
        if (i == 38) {
            return "Unable to save url:{0} because cannot encode all characters setting to blank instead";
        }
        if (i == 39) {
            return "Unable to find next atom because identifier is invalid {0}";
        }
        if (i == 40) {
            return "Unable to find next atom {0} because length is invalid {1}";
        }
        if (i == 41) {
            return "Argument cannot be null";
        }
        if (i == 42) {
            return "No genre id could be found for this genre atom with data length {0}";
        }
        if (i == 43) {
            return "Genre Id {0} does not map to a valid genre";
        }
        if (i == 44) {
            return "Picture Type is set to invalid value:{0}";
        }
        if (i == 45) {
            return "{0}:No key could be found with the value of:{1}";
        }
        if (i == 46) {
            return "Problem adjusting padding in large file, expecting to write:{0} only wrote:{1}";
        }
        if (i == 47) {
            return "Unable to delete the temporary file {0}";
        }
        if (i == 48) {
            return "Cannot modify {0} because do not have permissions to create files in the folder {1}";
        }
        if (i == 49) {
            return "Cannot modify {0} because do not have permissions to modify files in the folder {1}";
        }
        if (i == 50) {
            return "Cannot modify {0} because do not have permissions to modify file";
        }
        if (i == 51) {
            return "Null Padding found at end of file starting at offset {0}";
        }
        if (i == 52) {
            return "Could not find the Ogg Setup block";
        }
        if (i == 53) {
            return "OggS Header could not be found, not an ogg stream {0}";
        }
        if (i == 54) {
            return "Unable to close random access file: {0}";
        }
        if (i == 55) {
            return "Unable to read file because it is too small to be valid audio file: {0}";
        }
        if (i == 56) {
            return "Unable to read file do not have permission to read: {0}";
        }
        if (i == 57) {
            return "For file {0} the File header size is {1} but different to actual file size of {2}";
        }
        if (i == 58) {
            return "For file {0} the File Header missing. Invalid ASF/WMA file.";
        }
        if (i == 59) {
            return "For file {0} the Asf Header missing. Invalid ASF/WMA file.";
        }
        if (i == 60) {
            return "Cannot safetly identify the format of this image setting to default type of Png";
        }
        if (i == 61) {
            return "ImageFormat for cover art atom is not set to a known image format, instead set to {0}";
        }
        if (i == 62) {
            return "Filename {0}:{1} is compressed";
        }
        if (i == 63) {
            return "Filename {0}:{1} is encrypted";
        }
        if (i == 64) {
            return "Filename {0}:{1} is grouped";
        }
        if (i == 65) {
            return "Filename {0}:{1} is unsynchronised";
        }
        if (i == 66) {
            return "Filename {0}:{1} has a data length indicator";
        }
        if (i == 67) {
            return "This file does not currently contain any metadata";
        }
        if (i == 68) {
            return "Expect data in meta box to be null";
        }
        if (i == 69) {
            return "The field name {0} is not allowed for {1}";
        }
        if (i == 70) {
            return "The use of language {0} ist not allowed for {1} (only {2} allowed)";
        }
        if (i == 71) {
            return "The stream number {0} is invalid. Only {1} allowed for {2}.";
        }
        if (i == 72) {
            return "The use of GUID ist not allowed for {0}";
        }
        if (i == 73) {
            return "Trying to create field with {0} bytes of data but the maximum data allowed in WMA files is {1} for {2}.";
        }
        if (i == 74) {
            return "Trying to create language entry, but UTF-16LE representation is {0} and exceeds maximum allowed of 255.";
        }
        if (i == 75) {
            return "Trying to create field but UTF-16LE representation is {0} and exceeds maximum allowed of 65535.";
        }
        if (i == 76) {
            return "Only Strings are allowed in content description objects";
        }
        if (i == 77) {
            return "{0} Invalid Extended Header Size of {0} assuming no extended header after all";
        }
        if (i == 78) {
            return "{0} Invalid Extended Header Size of {0} is too smal to be valid";
        }
        if (i == 79) {
            return "{0} Invalid or unknown bit flag 0x{1} set in ID3 tag header";
        }
        if (i == 80) {
            return "{0} the ID3 Tag is unsynchronized";
        }
        if (i == 81) {
            return "{0} the ID3 Tag is experimental";
        }
        if (i == 82) {
            return "{0} the ID3 Tag is has a footer";
        }
        if (i == 83) {
            return "{0} the ID3 Tag is extended";
        }
        if (i == 84) {
            return "{0} the ID3 Tag has crc check";
        }
        if (i == 85) {
            return "{0} the ID3 Tag is compressed";
        }
        if (i == 86) {
            return "{0} According to Extended Header the ID3 Tag has crc32 of {1}";
        }
        if (i == 87) {
            return "{0} According to Extended Header the ID3 Tag has padding size of {1}";
        }
        if (i == 88) {
            return "{0} Tag size is {1} according to header (does not include header size, add 10)";
        }
        if (i == 89) {
            return "{0} CRC Data flag not set correctly.";
        }
        if (i == 90) {
            return "Unable to determine start of audio in file";
        }
        if (i == 91) {
            return "Comment field length is very large {0} , assuming comment is corrupt";
        }
        if (i == 92) {
            return "Comment field length {0} is larger than total comment header {1} ";
        }
        if (i == 93) {
            return "Cover Art cannot be created using this method";
        }
        if (i == 94) {
            return "Cover Art cannot be retrieved using this method";
        }
        if (i == 95) {
            return "Not implemented for this format";
        }
        if (i == 96) {
            return "Unable to decompress frame {0} in file {1} because {2}";
        }
        if (i == 97) {
            return "No Writer associated with this extension:{0}";
        }
        if (i == 98) {
            return "No Reader associated with this extension:{0}";
        }
        if (i == 99) {
            return "No Deleter associated with this extension:{0}";
        }
        if (i == 100) {
            return "Unable to find:{0}";
        }
        if (i == 101) {
            return "Unable to write to:{0}";
        }
        if (i == 102) {
            return "DO not know how to create this atom type {0}";
        }
        if (i == 103) {
            return "Ogg File contains invalid ID3 Tag, skipping ID3 Tag of length:{0}";
        }
        if (i == 104) {
            return "Flac File contains invalid ID3 Tag, skipping ID3 Tag of length:{0}";
        }
        if (i == 105) {
            return "Additional moov atom found at end of file starting at offset {0}";
        }
        if (i == 106) {
            return "The atom {0} states its data length to be {1} but there are only {2} bytes remaining in the file";
        }
        if (i == 107) {
            return "Invalid field {0} for ID3v1 tag";
        }
        if (i == 108) {
            return "No audio header found within {0}";
        }
        if (i == 109) {
            return "This is not a standard genre value, use custom genre field instead";
        }
        if (i == 110) {
            return "Flac file has invalid block type {0}";
        }
        throw null;
    }

    public static /* synthetic */ float d(int i) {
        if (i == 1) {
            return 1.5f;
        }
        if (i == 2) {
            return 1.1f;
        }
        if (i == 3) {
            return 1.2f;
        }
        if (i == 4) {
            return 1.3f;
        }
        if (i == 5) {
            return 1.4f;
        }
        if (i == 6) {
            return 1.5f;
        }
        if (i == 7) {
            return 1.6f;
        }
        if (i == 8) {
            return 1.7f;
        }
        if (i == 9) {
            return 1.8f;
        }
        throw null;
    }

    public static String j(String str, int i) {
        return str + i;
    }

    public static String k(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String l(String str, long j) {
        return str + j;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder p(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder q(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static LinkedHashMap r(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, str2);
        return linkedHashMap;
    }

    public static /* synthetic */ void s(View view) {
        if (view != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void t(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }


    public static String v(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ void w(Object obj) {
        throw new ClassCastException();
    }

    public static /* synthetic */ String x(int i) {
        if (i == 1) {
            return "L";
        }
        if (i == 2) {
            return "M";
        }
        if (i == 3) {
            return "Q";
        }
        if (i == 4) {
            return "H";
        }
        throw null;
    }

    public static /* synthetic */ int y(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String z(int i) {
        return i == 1 ? "INITIALIZE" : i == 2 ? "SWITCH_TO_SOURCE_SERVICE" : i == 3 ? "DECODE_DATA" : "null";
    }
}
