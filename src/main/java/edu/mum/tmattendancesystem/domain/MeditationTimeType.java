package edu.mum.tmattendancesystem.domain;

public enum MeditationTimeType {
    AM, EAM;

    public static MeditationTimeType getMeditationTimeType(String name){
        if(name.toLowerCase().equals("eam"))
            return MeditationTimeType.EAM;
        else
            return MeditationTimeType.AM;

    }
}
