package things;

import utilities.ThingInterface;

import java.util.Arrays;

public class Album implements ThingInterface {
    public static final int MAX_PAGES_COUNT_IN_ALBUM = 16;
    private final String name;
    Page[] pages = new Page[MAX_PAGES_COUNT_IN_ALBUM];

    public Album(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Stamp getStamp() {
        AlbumPointer pointer = AlbumPointer.getInstance();
        return pages[pointer.getPageNumber()].getPageContents()[pointer.getCellNumber()];
    }

    public void addStamp(Stamp stamp) throws AlbumFullException {
        AlbumPointer pointer = AlbumPointer.getInstance();
        for (int i = 0; i < MAX_PAGES_COUNT_IN_ALBUM; i++) {
            pointer.setPageNumber(i);
            pages[pointer.getPageNumber()] = new Page();
            for (int j = 0; j < Page.MAX_STAMPS_COUNT_ON_PAGE; j++) {
                pointer.setCellNumber(j);
                Stamp currentStamp = pages[pointer.getPageNumber()].getPageContents()[pointer.getCellNumber()];
                if (currentStamp == null) {
                    currentStamp = stamp;
                    return;
                }
            }
        }
        throw new AlbumFullException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Arrays.equals(pages, album.pages);
    }

    @Override
    public int hashCode() {
        int code = Integer.MIN_VALUE;
        for (Page page : pages) {
            code += page.hashCode();
        }
        return code;
    }

    @Override
    public String toString() {
        return "Альбом";
    }

    static class AlbumPointer {
        private int pageNumber;
        private int cellNumber;

        private AlbumPointer() {
            this.pageNumber = 0;
            this.cellNumber = 0;
        }

        public static AlbumPointer getInstance() {
            return new AlbumPointer();
        }

        public void setPointer(int pageNumber, int cellNumber) {
            setPageNumber(pageNumber);
            setCellNumber(cellNumber);
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getCellNumber() {
            return cellNumber;
        }

        public void setCellNumber(int cellNumber) {
            this.cellNumber = cellNumber;
        }
    }

    static class AlbumFullException extends Exception {
        public AlbumFullException() {
            super();
        }
    }

    class Page {
        public static final int MAX_STAMPS_COUNT_ON_PAGE = 8;
        Stamp[] stamps = new Stamp[MAX_STAMPS_COUNT_ON_PAGE];

        public Stamp[] getPageContents() {
            return stamps;
        }
    }
}
