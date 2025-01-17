package Persistence.DTO;

import java.sql.Blob;

public class AttachedFileDTO {
    public int attachedFileId;
    public int announcementId;
    public Blob attachedFile;

    public AttachedFileDTO(){
        attachedFileId = 0;
        announcementId = 0;
        attachedFile = null;
    }

    public AttachedFileDTO(int attachedFileId, int announcementId, Blob attachedFile) {
        this.attachedFileId = attachedFileId;
        this.announcementId = announcementId;
        this.attachedFile = attachedFile;
    }

    public int getAttachedFileId() {
        return attachedFileId;
    }

    public void setAttachedFileId(int attachedFileId) {
        this.attachedFileId = attachedFileId;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public Blob getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(Blob attachedFile) {
        this.attachedFile = attachedFile;
    }
}
