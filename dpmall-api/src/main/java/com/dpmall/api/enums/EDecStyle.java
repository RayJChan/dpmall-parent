package com.dpmall.api.enums;

public enum EDecStyle {
	RETRO_CH("retro","复古中式"),
	FRENCH_STYLE("french","法式风格"),
	BAROCO_STYLE("baroco","巴洛克"),
	RUSTIC_STYLE("rustic","乡村风格"),
	EUROPEAN_STYLE("european","欧式风格"),
	MIXMATCH_STYLE("mixmatch","时尚混搭"),
	CLASSIC_STYLE("classic","古典风格"),
    SIMPLE_STYLE("simple","简约风格"),
    ELEGANT_STYLE("elegant","精致风格"),
    NATURE_STYLE("nature","自然风格"),
    BRISK_STYLE("brisk","轻快风格"),
    SOFT_STYLE("","");
//	柔和风格
//	都市风格
//	清新风格
//	现代风格
//	田园风格
//	后现代风格
//	中式风格
//	欧式古典风格
//	地中海风格
//	东南亚风格
//	日式风格
	
    private String code;
	
	private String name;

	private EDecStyle(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
}
