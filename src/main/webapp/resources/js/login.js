/**
 * 入力値がnullまたはブランクかチェックする。
 */
 function checkIsNull(p_id, label) {
	var msgStr = [ label ];

	if (isNull(p_id)) {
		sendMessage("KS_FMSYS_ERRMSG_001_JS", msgStr);
		setFocus(p_id);
		return false;
	} else {
		return true;
	}
}


/**
 * 入力値がnullまたはブランクの場合、trueを返却する。
 */
 function isNull(p_id) {
	var input = document.getElementById(p_id);

	if (input === null || input.value == ""
			|| input.value.replace(/ /gi, "") == ""
			|| input.value == "undefined") {
		return true;
	} else {
		return false;
	}
}

/**
 * 入力値がアルファベットまたは数字かチェックする。
 */
 function checkIsAlphaNum(p_id) {
	if (!isAlphaNum(p_id)) {
		alert(KS_FMSYS_ERRMSG_006_JS);
		setFocus(p_id);
		return false;
	} else {
		return true;
	}
}

/**
 * 入力値が数字・アルファベットではない場合trueを返却する。
 */
 function isAlphaNum(p_id) {
	var input = document.getElementById(p_id);
	var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	return containsCharsOnly(input, chars);
}

/**
 * 入力値が数字の場合trueを返却する。
 */
 function isNumber(p_id) {
	var input = document.getElementById(p_id);
	var chars = "0123456789";

	return containsCharsOnly(input, chars);
}

/**
 * 入力値が数字かチェックする。
 */
 function checkIsNumber(p_id, label) {
	var msgStr = [ label ];

	if (!isNumber(p_id)) {
		sendMessage("KS_FMSYS_ERRMSG_004_JS", msgStr);
		setFocus(p_id);
		return false;
	} else {
		return true;
	}
}

/**
 * 入力値に特定文字だけ許容したい時使う。
 */
 function containsCharsOnly(input, chars) {
	for (var i = 0; i < input.value.length; i++) {
		if (chars.indexOf(input.value.charAt(i)) == -1) {
			return false;
		}
	}
	return true;
}

function messageCreate(msg, msgStr) {
	var targetStr = "";
	var modMsg = msg;

	for (var inx = 0; inx < msgStr.length; inx++) {
		targetStr = '{' + inx + '}';
		modMsg = modMsg.replace(targetStr, msgStr[inx]);
	}

	return modMsg;
}


/**
 * 文字列長さチェック。
 */
 function checkCharLength(p_id, p_min, p_max, label) {
	var msgStr = [ label, p_min, p_max ];
	var inputStr = document.getElementById(p_id).value;

	if (inputStr.length > p_max || inputStr.length < p_min) {
		if (inputStr.length != 0) {
			sendMessage("KS_FMSYS_ERRMSG_003_JS", msgStr);
			setFocus(p_id);
			return false;
		}
	} else {
		return true;
	}
}


/**
 * フォーカスを取得する。
 */
 function setFocus(p_id) {
	setTimeout(function() {
		document.getElementById(p_id).focus(), 10
	});
}


function sendMessage(msgId, msgStr) {
	var result = "";

	switch (msgId) {
	case "KS_FMSYS_ERRMSG_001_JS":
		result = messageCreate(KS_FMSYS_ERRMSG_001_JS, msgStr);
		alert(result);
		break;
		
	case "KS_FMSYS_ERRMSG_002_JS":
		result = messageCreate(KS_FMSYS_ERRMSG_002_JS, msgStr);
		alert(result);
		break;		

	case "KS_FMSYS_ERRMSG_003_JS":
		result = messageCreate(KS_FMSYS_ERRMSG_003_JS, msgStr);
		alert(result);
		break;

	case "KS_FMSYS_ERRMSG_004_JS":
		result = messageCreate(KS_FMSYS_ERRMSG_004_JS, msgStr);
		alert(result);
		break;

	case "KS_FMSYS_ERRMSG_005_JS":
		result = messageCreate(KS_FMSYS_ERRMSG_005_JS, msgStr);
		alert(result);
		break;
	}
}