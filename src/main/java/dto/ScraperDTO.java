package dto;

import lombok.*;


    @AllArgsConstructor
    @ToString
    @Getter
    @Setter
    @Builder
    public class ScraperDTO {
        private String teamName;
        private String location;
        private String arena;
        private int capacity;

    }

