package os.clipboard;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboradOperate {
    /**@Description: 
     * @author zhk
     * @createtime 2012-7-12 ����11:33:06   
     * @param args
     */
    public static void main(String[] args) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//��ȡϵͳ������

        try {
            ImageViewer im=new ImageViewer(getImageFromClipboard(clip));
            System.out.println(im);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * ��ָ���ļ��а��л�ȡ�ı�����
     * ���ؼ��а�ʹ�� Clipborad cp = new Clipboard("clip1"); ������
     * ϵͳ���а�ʹ��  Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
     * ���а������   getContents(null); ����Transferable
     */
    protected static String getClipboardText() throws Exception{
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//��ȡϵͳ������
        // ��ȡ���а��е�����
        Transferable clipT = clip.getContents(null);
        if (clipT != null) {
        // ��������Ƿ����ı�����
        if (clipT.isDataFlavorSupported(DataFlavor.stringFlavor))
        return (String)clipT.getTransferData(DataFlavor.stringFlavor); 
        }
        return null;
    }

     //�����а�д�ı�����
     protected static void setClipboardText(Clipboard clip, String writeMe) {
         Transferable tText = new StringSelection(writeMe);
         clip.setContents(tText, null);
     }

     // �Ӽ��а��ȡͼ��
     public static Image getImageFromClipboard(Clipboard clip) throws Exception{
         //Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
         Transferable cc = clip.getContents(null);
         if (cc == null)
         return null;
         else if(cc.isDataFlavorSupported(DataFlavor.imageFlavor))
         return (Image)cc.getTransferData(DataFlavor.imageFlavor);
         return null;
     }
     // дͼ�񵽼��а�
     protected static void setClipboardImage2(final Image image) {
         Transferable trans = new Transferable(){

         public DataFlavor[] getTransferDataFlavors() {
         return new DataFlavor[] { DataFlavor.imageFlavor };
     }

     public boolean isDataFlavorSupported(DataFlavor flavor) {
         return DataFlavor.imageFlavor.equals(flavor);
     }

     public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
         if(isDataFlavorSupported(flavor))
         return image;
         throw new UnsupportedFlavorException(flavor);
         }
         };
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
     }

}

