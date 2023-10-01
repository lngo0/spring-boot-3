package com.sample.sb3.constant;


import com.sample.sb3.entity.FileStatus;

public enum FileStatusContants {
    IN_PROCESS(inProcessStatus()),
    COMPLETED(completedStatus()),
    FAILED(failedStatus())
    ;

    private final FileStatus fileStatus;

    FileStatusContants(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }
    private static FileStatus inProcessStatus() {
        FileStatus status = new FileStatus();
        status.setId(1);
        status.setStatus("In Process");
        return status;
    }
    private static FileStatus completedStatus() {
        FileStatus status = new FileStatus();
        status.setId(2);
        status.setStatus("Completed");
        return status;
    }
    private static FileStatus failedStatus() {
        FileStatus status = new FileStatus();
        status.setId(3);
        status.setStatus("Failed");
        return status;
    }
}
