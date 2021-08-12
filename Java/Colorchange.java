public class Colorchange {

    public static void display_color_255(int color){
        int color_red=(color>>16)&0xff;
        int color_green=(color>>8)&0xff;
        int color_blue=(color)&0xff;
        System.out.println("("+color_red+","+color_green+","+color_blue+")");

    }
    public static void main(String[] args) {

        display_color_255(0x0f5f3f);
        
    }
}
