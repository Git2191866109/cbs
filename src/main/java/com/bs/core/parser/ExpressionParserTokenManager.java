/* Generated By:JavaCC: Do not edit this line. ExpressionParserTokenManager.java */
/** New line translator. */
package com.bs.core.parser;

public class ExpressionParserTokenManager implements ExpressionParserConstants {
	public java.io.PrintStream debugStream = System.out;

	public void setDebugStream(java.io.PrintStream ds) {
		debugStream = ds;
	}

	private final int jjStopStringLiteralDfa_0(int pos, long active0) {
		switch (pos) {
		case 0:
			if ((active0 & 0x2000000000L) != 0L)
				return 17;
			if ((active0 & 0x4000000000L) != 0L)
				return 18;
			return -1;
		default:
			return -1;
		}
	}

	private final int jjStartNfa_0(int pos, long active0) {
		return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
	}

	private final int jjStopAtPos(int pos, int kind) {
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		return pos + 1;
	}

	private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			return pos + 1;
		}
		return jjMoveNfa_0(state, pos + 1);
	}

	private final int jjMoveStringLiteralDfa0_0() {
		switch (curChar) {
		case 33:
			jjmatchedKind = 23;
			return jjMoveStringLiteralDfa1_0(0x100000L);
		case 34:
			return jjStartNfaWithStates_0(0, 37, 17);
		case 38:
			return jjMoveStringLiteralDfa1_0(0x200000L);
		case 39:
			return jjStartNfaWithStates_0(0, 38, 18);
		case 40:
			return jjStopAtPos(0, 32);
		case 41:
			return jjStopAtPos(0, 33);
		case 42:
			return jjStopAtPos(0, 26);
		case 43:
			return jjStopAtPos(0, 24);
		case 45:
			return jjStopAtPos(0, 25);
		case 47:
			return jjStopAtPos(0, 27);
		case 59:
			return jjStopAtPos(0, 36);
		case 60:
			jjmatchedKind = 16;
			return jjMoveStringLiteralDfa1_0(0x40000L);
		case 61:
			return jjMoveStringLiteralDfa1_0(0x80000L);
		case 62:
			jjmatchedKind = 15;
			return jjMoveStringLiteralDfa1_0(0x20000L);
		case 65:
		case 97:
			return jjMoveStringLiteralDfa1_0(0x100L);
		case 67:
		case 99:
			return jjMoveStringLiteralDfa1_0(0x400L);
		case 69:
		case 101:
			return jjMoveStringLiteralDfa1_0(0xc0L);
		case 70:
		case 102:
			return jjMoveStringLiteralDfa1_0(0x20000000000L);
		case 73:
		case 105:
			return jjMoveStringLiteralDfa1_0(0x20L);
		case 76:
		case 108:
			return jjMoveStringLiteralDfa1_0(0x1800L);
		case 78:
		case 110:
			return jjMoveStringLiteralDfa1_0(0x8000000000L);
		case 83:
		case 115:
			return jjMoveStringLiteralDfa1_0(0x2200L);
		case 84:
		case 116:
			return jjMoveStringLiteralDfa1_0(0x10000004000L);
		case 123:
			return jjStopAtPos(0, 34);
		case 124:
			return jjMoveStringLiteralDfa1_0(0x400000L);
		case 125:
			return jjStopAtPos(0, 35);
		default:
			return jjMoveNfa_0(0, 0);
		}
	}

	private final int jjMoveStringLiteralDfa1_0(long active0) {
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(0, active0);
			return 1;
		}
		switch (curChar) {
		case 38:
			if ((active0 & 0x200000L) != 0L)
				return jjStopAtPos(1, 21);
			break;
		case 61:
			if ((active0 & 0x20000L) != 0L)
				return jjStopAtPos(1, 17);
			else if ((active0 & 0x40000L) != 0L)
				return jjStopAtPos(1, 18);
			else if ((active0 & 0x80000L) != 0L)
				return jjStopAtPos(1, 19);
			else if ((active0 & 0x100000L) != 0L)
				return jjStopAtPos(1, 20);
			break;
		case 65:
		case 97:
			return jjMoveStringLiteralDfa2_0(active0, 0x20000004000L);
		case 66:
		case 98:
			return jjMoveStringLiteralDfa2_0(active0, 0x100L);
		case 70:
		case 102:
			if ((active0 & 0x20L) != 0L)
				return jjStopAtPos(1, 5);
			break;
		case 73:
		case 105:
			return jjMoveStringLiteralDfa2_0(active0, 0x200L);
		case 76:
		case 108:
			return jjMoveStringLiteralDfa2_0(active0, 0xc0L);
		case 79:
		case 111:
			return jjMoveStringLiteralDfa2_0(active0, 0x1c00L);
		case 81:
		case 113:
			return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
		case 82:
		case 114:
			return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L);
		case 85:
		case 117:
			return jjMoveStringLiteralDfa2_0(active0, 0x8000000000L);
		case 124:
			if ((active0 & 0x400000L) != 0L)
				return jjStopAtPos(1, 22);
			break;
		default:
			break;
		}
		return jjStartNfa_0(0, active0);
	}

	private final int jjMoveStringLiteralDfa2_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(0, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(1, active0);
			return 2;
		}
		switch (curChar) {
		case 71:
		case 103:
			if ((active0 & 0x800L) != 0L) {
				jjmatchedKind = 11;
				jjmatchedPos = 2;
			}
			return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
		case 76:
		case 108:
			return jjMoveStringLiteralDfa3_0(active0, 0x28000000000L);
		case 78:
		case 110:
			if ((active0 & 0x200L) != 0L)
				return jjStopAtPos(2, 9);
			else if ((active0 & 0x4000L) != 0L)
				return jjStopAtPos(2, 14);
			break;
		case 82:
		case 114:
			return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
		case 83:
		case 115:
			if ((active0 & 0x100L) != 0L)
				return jjStopAtPos(2, 8);
			else if ((active0 & 0x400L) != 0L)
				return jjStopAtPos(2, 10);
			return jjMoveStringLiteralDfa3_0(active0, 0xc0L);
		case 85:
		case 117:
			return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
		default:
			break;
		}
		return jjStartNfa_0(1, active0);
	}

	private final int jjMoveStringLiteralDfa3_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(1, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(2, active0);
			return 3;
		}
		switch (curChar) {
		case 49:
			return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
		case 69:
		case 101:
			if ((active0 & 0x80L) != 0L) {
				jjmatchedKind = 7;
				jjmatchedPos = 3;
			} else if ((active0 & 0x10000000000L) != 0L)
				return jjStopAtPos(3, 40);
			return jjMoveStringLiteralDfa4_0(active0, 0x40L);
		case 76:
		case 108:
			if ((active0 & 0x8000000000L) != 0L)
				return jjStopAtPos(3, 39);
			break;
		case 83:
		case 115:
			return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
		case 84:
		case 116:
			if ((active0 & 0x2000L) != 0L)
				return jjStopAtPos(3, 13);
			break;
		default:
			break;
		}
		return jjStartNfa_0(2, active0);
	}

	private final int jjMoveStringLiteralDfa4_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(2, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(3, active0);
			return 4;
		}
		switch (curChar) {
		case 48:
			if ((active0 & 0x1000L) != 0L)
				return jjStopAtPos(4, 12);
			break;
		case 69:
		case 101:
			if ((active0 & 0x20000000000L) != 0L)
				return jjStopAtPos(4, 41);
			break;
		case 73:
		case 105:
			return jjMoveStringLiteralDfa5_0(active0, 0x40L);
		default:
			break;
		}
		return jjStartNfa_0(3, active0);
	}

	private final int jjMoveStringLiteralDfa5_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(3, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(4, active0);
			return 5;
		}
		switch (curChar) {
		case 70:
		case 102:
			if ((active0 & 0x40L) != 0L)
				return jjStopAtPos(5, 6);
			break;
		default:
			break;
		}
		return jjStartNfa_0(4, active0);
	}

	private final void jjCheckNAdd(int state) {
		if (jjrounds[state] != jjround) {
			jjstateSet[jjnewStateCnt++] = state;
			jjrounds[state] = jjround;
		}
	}

	@SuppressWarnings("unused")
	private final void jjAddStates(int start, int end) {
		do {
			jjstateSet[jjnewStateCnt++] = jjnextStates[start];
		} while (start++ != end);
	}

	private final void jjCheckNAddTwoStates(int state1, int state2) {
		jjCheckNAdd(state1);
		jjCheckNAdd(state2);
	}

	private final void jjCheckNAddStates(int start, int end) {
		do {
			jjCheckNAdd(jjnextStates[start]);
		} while (start++ != end);
	}

	@SuppressWarnings("unused")
	private final void jjCheckNAddStates(int start) {
		jjCheckNAdd(jjnextStates[start]);
		jjCheckNAdd(jjnextStates[start + 1]);
	}

	@SuppressWarnings("unused")
	private final int jjMoveNfa_0(int startState, int curPos) {
		int[] nextStates;
		int startsAt = 0;
		jjnewStateCnt = 17;
		int i = 1;
		jjstateSet[0] = startState;
		int j, kind = 0x7fffffff;
		for (;;) {
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64) {
				long l = 1L << curChar;
				MatchLoop: do {
					switch (jjstateSet[--i]) {
					case 17:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(0, 2);
						else if ((0x400647b00000000L & l) != 0L)
							jjCheckNAddStates(0, 2);
						else if (curChar == 34) {
							if (kind > 28)
								kind = 28;
						}
						break;
					case 18:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						else if ((0x400647b00000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						else if (curChar == 39) {
							if (kind > 28)
								kind = 28;
						}
						break;
					case 0:
						if ((0x3ff000000000000L & l) != 0L) {
							if (kind > 29)
								kind = 29;
							jjCheckNAddStates(6, 10);
						} else if (curChar == 39)
							jjCheckNAddStates(3, 5);
						else if (curChar == 34)
							jjCheckNAddStates(0, 2);
						else if (curChar == 46)
							jjCheckNAdd(1);
						break;
					case 1:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 29)
							kind = 29;
						jjCheckNAdd(1);
						break;
					case 2:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 29)
							kind = 29;
						jjCheckNAddStates(6, 10);
						break;
					case 3:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 29)
							kind = 29;
						jjCheckNAdd(3);
						break;
					case 4:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(4, 5);
						break;
					case 5:
						if (curChar == 46)
							jjCheckNAdd(6);
						break;
					case 6:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 29)
							kind = 29;
						jjCheckNAdd(6);
						break;
					case 7:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(7, 8);
						break;
					case 8:
						if (curChar == 46 && kind > 29)
							kind = 29;
						break;
					case 9:
						if (curChar == 34)
							jjCheckNAddStates(0, 2);
						break;
					case 10:
						if ((0x400647b00000000L & l) != 0L)
							jjCheckNAddStates(0, 2);
						break;
					case 11:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(0, 2);
						break;
					case 12:
						if (curChar == 34 && kind > 28)
							kind = 28;
						break;
					case 13:
						if (curChar == 39)
							jjCheckNAddStates(3, 5);
						break;
					case 14:
						if ((0x400647b00000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 15:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 16:
						if (curChar == 39 && kind > 28)
							kind = 28;
						break;
					default:
						break;
					}
				} while (i != startsAt);
			} else if (curChar < 128) {
				long l = 1L << (curChar & 077);
				MatchLoop: do {
					switch (jjstateSet[--i]) {
					case 17:
					case 10:
						if ((0x7fffffec7ffffffL & l) != 0L)
							jjCheckNAddStates(0, 2);
						break;
					case 18:
					case 14:
						if ((0x7fffffec7ffffffL & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					default:
						break;
					}
				} while (i != startsAt);
			} else {
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				MatchLoop: do {
					switch (jjstateSet[--i]) {
					default:
						break;
					}
				} while (i != startsAt);
			}
			if (kind != 0x7fffffff) {
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 17 - (jjnewStateCnt = startsAt)))
				return curPos;
			try {
				curChar = input_stream.readChar();
			} catch (java.io.IOException e) {
				return curPos;
			}
		}
	}

	static final int[] jjnextStates = { 10, 11, 12, 14, 15, 16, 3, 4, 5, 7, 8, };
	public static final String[] jjstrLiteralImages = { "", null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			"\76", "\74", "\76\75", "\74\75", "\75\75", "\41\75", "\46\46",
			"\174\174", "\41", "\53", "\55", "\52", "\57", null, null, null,
			null, "\50", "\51", "\173", "\175", "\73", "\42", "\47", null,
			null, null, };
	public static final String[] lexStateNames = { "DEFAULT", };
	static final long[] jjtoToken = { 0x3ff3fffffe1L, };
	static final long[] jjtoSkip = { 0x1eL, };
	protected SimpleCharStream input_stream;
	private final int[] jjrounds = new int[17];
	private final int[] jjstateSet = new int[34];
	protected char curChar;

	public ExpressionParserTokenManager(SimpleCharStream stream) {
		if (SimpleCharStream.staticFlag)
			throw new Error(
					"ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
		input_stream = stream;
	}

	public ExpressionParserTokenManager(SimpleCharStream stream, int lexState) {
		this(stream);
		SwitchTo(lexState);
	}

	public void ReInit(SimpleCharStream stream) {
		jjmatchedPos = jjnewStateCnt = 0;
		curLexState = defaultLexState;
		input_stream = stream;
		ReInitRounds();
	}

	private final void ReInitRounds() {
		int i;
		jjround = 0x80000001;
		for (i = 17; i-- > 0;)
			jjrounds[i] = 0x80000000;
	}

	public void ReInit(SimpleCharStream stream, int lexState) {
		ReInit(stream);
		SwitchTo(lexState);
	}

	public void SwitchTo(int lexState) {
		if (lexState >= 1 || lexState < 0)
			throw new TokenMgrError("Error: Ignoring invalid lexical state : "
					+ lexState + ". State unchanged.",
					TokenMgrError.INVALID_LEXICAL_STATE);
		else
			curLexState = lexState;
	}

	protected Token jjFillToken() {
		Token t = Token.newToken(jjmatchedKind);
		t.kind = jjmatchedKind;
		String im = jjstrLiteralImages[jjmatchedKind];
		t.image = (im == null) ? input_stream.GetImage() : im;
		t.beginLine = input_stream.getBeginLine();
		t.beginColumn = input_stream.getBeginColumn();
		t.endLine = input_stream.getEndLine();
		t.endColumn = input_stream.getEndColumn();
		return t;
	}

	int curLexState = 0;
	int defaultLexState = 0;
	int jjnewStateCnt;
	int jjround;
	int jjmatchedPos;
	int jjmatchedKind;

	@SuppressWarnings("unused")
	public Token getNextToken() {
		int kind;
		Token specialToken = null;
		Token matchedToken;
		int curPos = 0;

		EOFLoop: for (;;) {
			try {
				curChar = input_stream.BeginToken();
			} catch (java.io.IOException e) {
				jjmatchedKind = 0;
				matchedToken = jjFillToken();
				return matchedToken;
			}

			try {
				input_stream.backup(0);
				while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
					curChar = input_stream.BeginToken();
			} catch (java.io.IOException e1) {
				continue EOFLoop;
			}
			jjmatchedKind = 0x7fffffff;
			jjmatchedPos = 0;
			curPos = jjMoveStringLiteralDfa0_0();
			if (jjmatchedKind != 0x7fffffff) {
				if (jjmatchedPos + 1 < curPos)
					input_stream.backup(curPos - jjmatchedPos - 1);
				if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
					matchedToken = jjFillToken();
					return matchedToken;
				} else {
					continue EOFLoop;
				}
			}
			int error_line = input_stream.getEndLine();
			int error_column = input_stream.getEndColumn();
			String error_after = null;
			boolean EOFSeen = false;
			try {
				input_stream.readChar();
				input_stream.backup(1);
			} catch (java.io.IOException e1) {
				EOFSeen = true;
				error_after = curPos <= 1 ? "" : input_stream.GetImage();
				if (curChar == '\n' || curChar == '\r') {
					error_line++;
					error_column = 0;
				} else
					error_column++;
			}
			if (!EOFSeen) {
				input_stream.backup(1);
				error_after = curPos <= 1 ? "" : input_stream.GetImage();
			}
			throw new TokenMgrError(EOFSeen, curLexState, error_line,
					error_column, error_after, curChar,
					TokenMgrError.LEXICAL_ERROR);
		}
	}

}