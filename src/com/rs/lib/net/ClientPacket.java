//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.rs.lib.net;

import java.util.HashMap;
import java.util.Map;

public enum ClientPacket {
    KEEPALIVE(0, 0),
    PLAYER_OP6(1, 3),
    SOUND_EFFECT_MUSIC_ENDED(2, 4),
    NPC_EXAMINE(3, 3),
    IF_ON_IF(4, 16),
    WORLD_MAP_CLICK(5, 4),
    PLAYER_OP2(6, 3),
    FC_SET_RANK(7, -1),
    GROUND_ITEM_OP4(8, 7),
    IF_OP4(9, 8),
    SEND_PREFERENCES(10, -1),
    RESUME_HSLDIALOG(11, 2),
    REMOVE_IGNORE(12, -1),
    IF_ON_PLAYER(13, 11),
    QUICKCHAT_PRIVATE(14, -1),
    SEND_PRIVATE_MESSAGE(15, -2),
    NPC_OP2(16, 3),
    GE_ITEM_SELECT(17, 2),
    SONG_LOADED(18, 4),
    IF_OP6(19, 8),
    CHAT_SETFILTER(20, 3),
    IF_OP8(21, 8),
    IF_OP9(22, 8),
    IF_OP7(23, 8),
    GROUND_ITEM_OP1(24, 7),
    GROUND_ITEM_OP2(25, 7),
    ADD_FRIEND(26, -1),
    IF_OP2(27, 8),
    KEY_PRESS(28, -2),
    REMOVE_FRIEND(29, -1),
    CHAT_TYPE(30, 1),
    PLAYER_OP3(31, 3),
    OBJECT_OP4(32, 9),
    WALK(33, 5),
    ADD_IGNORE(34, -1),
    BUG_REPORT(35, -2),
    REFLECTION_CHECK(36, -1),
    UNK_37(37, 2),
    OBJECT_OP3(38, 9),
    UNUSED_CLAN_OP(39, -1),
    MOVE_MOUSE(40, -1),
    IF_ON_NPC(41, 11),
    MINI_WALK(42, 18),
    GROUND_ITEM_OP5(43, 7),
    SEND_FPS(44, 9),
    CUTSCENE_FINISHED(45, 1),
    IF_ON_TILE(46, 12),
    REQUEST_WORLD_LIST(47, 4),
    OBJECT_OP5(48, 9),
    IF_CONTINUE(49, 6),
    NPC_OP3(50, 3),
    PLAYER_OP7(51, 3),
    EMAIL_VALIDATION_SUBMIT_CODE(52, -1),
    PLAYER_OP9(53, 3),
    GROUND_ITEM_OP3(54, 7),
    TRANSMITVAR_VERIFYID(55, 4),
    LOBBY_HYPERLINK(56, -2),
    MOUSE_BUTTON_CLICK(57, 7),
    RESUME_COUNTDIALOG(58, 4),
    MOUSE_CLICK(59, 6),
    CLOSE_INTERFACE(60, 0),
    GROUND_ITEM_EXAMINE(61, 7),
    CLIENT_FOCUS(62, 1),
    UNK_63(63, 4),
    QUICKCHAT_PUBLIC(64, -1),
    NPC_OP1(65, 3),
    PLAYER_OP1(66, 3),
    IF_ON_GROUND_ITEM(67, 15),
    IF_OP3(68, 8),
    RESUME_CLANFORUMQFCDIALOG(69, -1),
    PLAYER_OP10(70, 3),
    FC_JOIN(71, -1),
    IF_OP5(72, 8),
    OBJECT_EXAMINE(73, 9),
    IF_DRAG_ONTO_IF(74, 16),
    OBJECT_OP1(75, 9),
    REGION_LOADED_CONFIRM(76, 0),
    NPC_OP4(77, 3),
    MOVE_MOUSE_2(78, -1),
    ACCOUNT_CREATION_STAGE(79, 1),
    RESUME_NAMEDIALOG(80, -1),
    IF_OP10(81, 8),
    UNK_82(82, 4),
    MOVE_CAMERA(83, 4),
    SCREEN_SIZE(84, 6),
    CLIENT_CHEAT(85, -1),
    CHAT(86, -1),
    RESUME_TEXTDIALOG(87, -1),
    WRITE_PING(88, 2),
    PLAYER_OP4(89, 3),
    CLANCHANNEL_KICKUSER(90, -1),
    FC_KICK(91, -1),
    EMAIL_VALIDATION_ADD_NEW_ADDRESS(92, -2),
    OBJECT_OP2(93, 9),
    PLAYER_OP8(94, 3),
    NPC_OP5(95, 3),
    IF_OP1(96, 8),
    UNK_97(97, -1),
    IF_ON_OBJECT(98, 17),
    EMAIL_VALIDATION_CHANGE_ADDRESS(99, -2),
    REPORT_ABUSE(100, -1),
    SEND_SIGN_UP_FORM(101, -2),
    CHECK_EMAIL_VALIDITY(102, -2),
    PLAYER_OP5(103, 3),
    CC_JOIN(5000, 0),
    CC_LEAVE(5001, 0),
    CC_BAN(5002, 0),
    CLAN_CHECKNAME(5003, 0),
    CLAN_CREATE(5004, 0),
    CLAN_LEAVE(5005, 0),
    CLAN_ADDMEMBER(5006, 0),
    CLAN_KICKMEMBER(5007, 0);

    private int id;
    private int size;
	private static Map PACKET_MAP = new HashMap();

    public static ClientPacket forOpcode(int opcode) {
        return (ClientPacket)PACKET_MAP.get(opcode);
    }

    private ClientPacket(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getOpcode() {
        return this.id;
    }

    public int getSize() {
        return this.size;
    }

    static {
        ClientPacket[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ClientPacket packet = var0[var2];
            PACKET_MAP.put(packet.id, packet);
        }

    }
}
