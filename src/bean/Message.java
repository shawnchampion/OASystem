package bean;

import java.sql.Timestamp;

public class Message {
	private int msgid;
	private String senderid;
	private String receiverid;
	private String sendername;
	private String receivername;
	private String header;
	private String content;
	private Timestamp sendtime;
	private Timestamp receivetime;
	private boolean sended;
	private boolean readed;
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSendtime() {
		return sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}
	public Timestamp getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Timestamp receivetime) {
		this.receivetime = receivetime;
	}
	public boolean isSended() {
		return sended;
	}
	public void setSended(boolean sended) {
		this.sended = sended;
	}
	public boolean isReaded() {
		return readed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public Message(int msgid, String senderid, String receiverid, String sendername, String receivername, String header,
			String content, Timestamp sendtime, Timestamp receivetime, boolean sended, boolean readed) {
		super();
		this.msgid = msgid;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.sendername = sendername;
		this.receivername = receivername;
		this.header = header;
		this.content = content;
		this.sendtime = sendtime;
		this.receivetime = receivetime;
		this.sended = sended;
		this.readed = readed;
	}
}
