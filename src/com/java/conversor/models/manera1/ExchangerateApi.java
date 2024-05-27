package com.java.conversor.models;

public record ExchangerateApi(String result,
                              int time_last_update_unix,
                              String time_last_update_utc,
                              int time_next_update_unix,
                              String time_next_update_utc,
                              String base_code,
                              String target_code,
                              double conversion_rate,
                              double conversion_result) {
}
